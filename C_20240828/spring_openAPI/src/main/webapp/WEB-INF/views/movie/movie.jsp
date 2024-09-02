<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movie Details</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .movie-info {
            margin-top: 20px;
        }
        .movie-info div {
            margin-bottom: 8px;
        }
    </style>
    <!-- Axios CDN 추가 -->
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>

<h1>Movie Details</h1>
<button  class="btn btn-primary mb-4"  onclick="movie_all()">Get Movie All</button>
<button  class="btn btn-danger mb-4"  onclick="movie_get()">Get Movie Information</button>
<button  class="btn btn-info mb-4"  onclick="fetchMovieDetails()">Load Movie Details</button>
<div id="movieDetails" class="movie-info"></div>

<script>
    function fetchMovieDetails() {
        axios.get('api/movie?movieCd=1')
            .then(response => {
                const movie = response.data;
                console.log(movie)
                console.log(movie.movieNm)
                let movieDetailsDiv = document.getElementById('movieDetails');
                movieDetailsDiv.innerHTML =
                    '<div><strong>순번:</strong> ' + movie.rnum+ '</div>' +
                    '<div><strong>랭킹:</strong> ' + movie.ranks + '</div>' +
                    '<div><strong>랭킹 증감:</strong> ' + movie.rankInten + '</div>' +
                    '<div><strong>신규/기존 여부:</strong> ' + movie.rankOldAndNew + '</div>' +
                    '<div><strong>영화 코드:</strong> ' + movie.movieCd + '</div>' +
                    '<div><strong>영화 이름:</strong> ' + movie.movieNm + '</div>' +
                    '<div><strong>개봉일:</strong> ' + movie.openDt + '</div>' +
                    '<div><strong>매출액:</strong> ' + movie.salesAmt + '</div>' +
                    '<div><strong>매출 점유율:</strong> ' + movie.salesShare + '</div>' +
                    '<div><strong>전일 대비 매출 증감:</strong> ' + movie.salesInten + '</div>' +
                    '<div><strong>매출 증감 비율:</strong> ' + movie.salesChange + '</div>' +
                    '<div><strong>누적 매출액:</strong> ' + movie.salesAcc + '</div>' +
                    '<div><strong>관객수:</strong> ' + movie.audiCnt + '</div>' +
                    '<div><strong>전일 대비 관객 증감:</strong> ' + movie.audiInten + '</div>' +
                    '<div><strong>관객 증감 비율:</strong> ' + movie.audiChange + '</div>' +
                    '<div><strong>누적 관객수:</strong> ' + movie.audiAcc + '</div>' +
                    '<div><strong>상영 스크린 수:</strong> ' + movie.scrnCnt + '</div>' +
                    '<div><strong>상영 횟수:</strong> ' + movie.showCnt + '</div>' +
                    '<hr/>';
            })
            .catch(error => {
                console.error('Error fetching movie details:', error);
                alert('영화 정보를 불러오는데 실패했습니다.');
            });
    } //fun

    async function movie_get() {
        try {
            const response = await axios.get('https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json', {
                params: {
                    key: '1e36b79fd2d16b1ef3f53a9682ade7f0',
                    targetDt: '20231209'
                }
            });

            const boxList = response.data.boxOfficeResult.dailyBoxOfficeList;
            let movieDetailsHtml = '';
            console.log(boxList);

            // 비동기적으로 하나씩 서버로 데이터를 전송
            for (const movie of boxList) {
                movieDetailsHtml +=
                    '<div><strong>순번:</strong> ' + movie.rnum + '</div>' +
                    '<div><strong>랭킹:</strong> ' + movie.rank + '</div>' +
                    '<div><strong>랭킹 증감:</strong> ' + movie.rankInten + '</div>' +
                    '<div><strong>신규/기존 여부:</strong> ' + movie.rankOldAndNew + '</div>' +
                    '<div><strong>영화 코드:</strong> ' + movie.movieCd + '</div>' +
                    '<div><strong>영화 이름:</strong> ' + movie.movieNm + '</div>' +
                    '<div><strong>개봉일:</strong> ' + movie.openDt + '</div>' +
                    '<div><strong>매출액:</strong> ' + movie.salesAmt + '</div>' +
                    '<div><strong>매출 점유율:</strong> ' + movie.salesShare + '</div>' +
                    '<div><strong>전일 대비 매출 증감:</strong> ' + movie.salesInten + '</div>' +
                    '<div><strong>매출 증감 비율:</strong> ' + movie.salesChange + '</div>' +
                    '<div><strong>누적 매출액:</strong> ' + movie.salesAcc + '</div>' +
                    '<div><strong>관객수:</strong> ' + movie.audiCnt + '</div>' +
                    '<div><strong>전일 대비 관객 증감:</strong> ' + movie.audiInten + '</div>' +
                    '<div><strong>관객 증감 비율:</strong> ' + movie.audiChange + '</div>' +
                    '<div><strong>누적 관객수:</strong> ' + movie.audiAcc + '</div>' +
                    '<div><strong>상영 스크린 수:</strong> ' + movie.scrnCnt + '</div>' +
                    '<div><strong>상영 횟수:</strong> ' + movie.showCnt + '</div>' +
                    '<hr/>';

                console.log(movie)

                // 서버로 데이터를 순차적으로 전송
                await sendMoviesToServer(movie);

                // 1초 대기
                await delay(1000);
            }
            document.getElementById('movieDetails').innerHTML = movieDetailsHtml;

        } catch (error) {
            console.error('Error fetching movie details:', error);
            alert('영화 정보를 불러오는데 실패했습니다.');
        }
    }

    async function sendMoviesToServer(movie) {
        try {
            const insertResponse = await axios.post('api/insert', {
                rnum: movie.rnum,
                ranks: movie.rank,
                rankInten: movie.rankInten,
                rankOldAndNew: movie.rankOldAndNew,
                movieCd: movie.movieCd,
                movieNm: movie.movieNm,
                openDt: movie.openDt,
                salesAmt: movie.salesAmt,
                salesShare: movie.salesShare,
                salesInten: movie.salesInten,
                salesChange: movie.salesChange,
                salesAcc: movie.salesAcc,
                audiCnt: movie.audiCnt,
                audiInten: movie.audiInten,
                audiChange: movie.audiChange,
                audiAcc: movie.audiAcc,
                scrnCnt: movie.scrnCnt,
                showCnt: movie.showCnt
            });
            console.log('영화 정보가 성공적으로 저장되었습니다:', insertResponse.data);
        } catch (insertError) {
            console.error('영화 정보를 저장하는데 오류가 발생했습니다:', insertError);
        }
    }

    function delay(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }

    function movie_all() {
        axios.get('api/all')
            .then(response => {
                const movies = response.data;
                let movieDetailsHtml = `
                    <table class="table table-bordered table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>순번</th>
                                <th>랭킹</th>
                                <th>랭킹 증감</th>
                                <th>신규/기존 여부</th>
                                <th>영화 코드</th>
                                <th>영화 이름</th>
                                <th>개봉일</th>
                                <th>매출액</th>
                                <th>매출 점유율</th>
                                <th>전일 대비 매출 증감</th>
                                <th>매출 증감 비율</th>
                                <th>누적 매출액</th>
                                <th>관객수</th>
                                <th>전일 대비 관객 증감</th>
                                <th>관객 증감 비율</th>
                                <th>누적 관객수</th>
                                <th>상영 스크린 수</th>
                                <th>상영 횟수</th>
                            </tr>
                        </thead>
                        <tbody>
                `;

                movies.forEach(movie => {
                    movieDetailsHtml +=
                        '<tr>' +
                        '<td>' + movie.rnum + '</td>' +
                        '<td>' + movie.ranks + '</td>' +
                        '<td>' + movie.rankInten + '</td>' +
                        '<td>' + movie.rankOldAndNew + '</td>' +
                        '<td>' + movie.movieCd + '</td>' +
                        '<td>' + movie.movieNm + '</td>' +
                        '<td>' + movie.openDt + '</td>' +
                        '<td>' + movie.salesAmt + '</td>' +
                        '<td>' + movie.salesShare + '</td>' +
                        '<td>' + movie.salesInten + '</td>' +
                        '<td>' + movie.salesChange + '</td>' +
                        '<td>' + movie.salesAcc + '</td>' +
                        '<td>' + movie.audiCnt + '</td>' +
                        '<td>' + movie.audiInten + '</td>' +
                        '<td>' + movie.audiChange + '</td>' +
                        '<td>' + movie.audiAcc + '</td>' +
                        '<td>' + movie.scrnCnt + '</td>' +
                        '<td>' + movie.showCnt + '</td>' +
                        '</tr>';



                });

                movieDetailsHtml += `
                        </tbody>
                    </table>
                `;

                document.getElementById('movieDetails').innerHTML = movieDetailsHtml;
            })
            .catch(error => {
                console.error('Error fetching movie list:', error);
                alert('영화 목록을 불러오는 데 실패했습니다.');
            });
    }
</script>


</body>
</html>
