<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>People Details</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .people-info {
            margin-top: 20px;
        }
        .people-info div {
            margin-bottom: 8px;
        }
    </style>
    <!-- Axios CDN 추가 -->
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>

<h1>People Details</h1>
<button class="btn btn-primary mb-4" onclick="people_all()">Get All People</button>
<button class="btn btn-danger mb-4" onclick="people_get()">Get People Information</button>
<div id="peopleDetails" class="people-info"></div>

<script>

    async function people_get() {
        try {
            /*<코드 구현 부분>*/
            const response = await axios.get('http://www.kobis.or.kr/kobisopenapi/webservice/rest/people/searchPeopleList.json', {
                params: {
                    key: '1e36b79fd2d16b1ef3f53a9682ade7f0',
                    curPage: '1',
                    itemPerPage: '10',
                }
            });

            const peopleList = response.data.peopleListResult.peopleList;
            console.log(peopleList);

            /*<코드 구현 부분>*/
            let peopleDetailsHtml = '';

            for (const person of peopleList) {
                peopleDetailsHtml +=
                    '<div><strong>영화인 코드 : </strong>' + person.peopleCd + '</div>' +
                    '<div><strong>영화인명 : </strong>' + person.peopleNm + '</div>' +
                    '<div><strong>영화인명(영문) : </strong>' + person.peopleNmEn + '</div>' +
                    '<div><strong>분야 : </strong>' + person.repRoleNm + '</div>' +
                    '<div><strong>필모리스트 : </strong>' + person.filmoNames + '</div>' +
                    '<hr/>';

                console.log(person)
                await sendPeopleToServer(person);
                await delay(1000);
            }
            document.getElementById('peopleDetails').innerHTML = "<h1>Complete!</h1>";

        } catch (error) {
            console.error('Error fetching people details:', error);
            alert('영화인 정보를 불러오는데 실패했습니다.');
        }
    }

    async function sendPeopleToServer(person) {
        try {
            /*<코드 구현 부분>*/
            const insertResponse = await axios.post('people/insert', {
                peopleCd : person.peopleCd,
                peopleNm : person.peopleNm,
                peopleNmEn : person.peopleNmEn,
                repRoleNm : person.repRoleNm,
                filmoNames : person.filmoNames
            });
            console.log('영화인 정보가 성공적으로 저장되었습니다:', insertResponse.data);
        } catch (insertError) {
            console.error('영화인 정보를 저장하는데 오류가 발생했습니다:', insertError);
        }
    }

    function people_all() {
        axios.get('people/all')
            .then(response => {
                const peopleList = response.data;
                let peopleDetailsHtml = `
                    <table class="table table-bordered table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>영화인 코드</th>
                                <th>영화인명</th>
                                <th>영화인명(영문)</th>
                                <th>분야</th>
                                <th>필모리스트</th>
                            </tr>
                        </thead>
                        <tbody>
                `;

                /*<코드 구현 부분>*/
                peopleList.forEach(person => {
                    peopleDetailsHtml +=
                        '<tr>' +
                        '<td>' + person.peopleCd + '</td>' +
                        '<td>' + person.peopleNm + '</td>' +
                        '<td>' + person.peopleNmEn + '</td>' +
                        '<td>' + person.repRoleNm + '</td>' +
                        '<td>' + person.filmoNames + '</td>' +
                        '</tr>'
                });

                peopleDetailsHtml += `
                        </tbody>
                    </table>
                `;

                document.getElementById('peopleDetails').innerHTML = peopleDetailsHtml;
            })
            .catch(error => {
                console.error('Error fetching people list:', error);
                alert('영화인 목록을 불러오는 데 실패했습니다.');
            });
    }
    function delay(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
</script>

</body>
</html>
