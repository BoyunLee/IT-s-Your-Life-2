package com.multi.spring2.movie.controller;

import com.multi.spring2.movie.domain.MovieVO;
import com.multi.spring2.movie.service.MovieService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
@Api(value = "MovieController", tags = "영화정보")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String index() {
        return "movie/movie";
    }

    @GetMapping("/test")
    public String test() {
        return "movie/api_test";
    }

    @GetMapping("/movie")
    @ResponseBody
    @ApiOperation(value = "영화 상세 정보 조회", notes = "특정 영화의 상세 정보를 반환합니다.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "성공적으로 요청이 처리되었습니다."),
            @ApiResponse(code = 400, message = "잘못된 요청입니다."),
            @ApiResponse(code = 500, message = "서버에서 오류가 발생했습니다.")
    })
    public MovieVO getMovieDetails(
            @ApiParam(value = "movieCd", required = true, example = "20240810") String movieCd) {
        // 임의의 영화 정보를 생성하여 반환
        MovieVO movie = new MovieVO();
        movie.setRnum("1");
        movie.setRanks("1");
        movie.setRankInten("0");
        movie.setRankOldAndNew("OLD");
        movie.setMovieCd("20112207");
        movie.setMovieNm("미션임파서블:고스트프로토콜");
        movie.setOpenDt("2011-12-15");
        movie.setSalesAmt("2776060500");
        movie.setSalesShare("36.3");
        movie.setSalesInten("-415699000");
        movie.setSalesChange("-13");
        movie.setSalesAcc("40541108500");
        movie.setAudiCnt("353274");
        movie.setAudiInten("-60106");
        movie.setAudiChange("-14.5");
        movie.setAudiAcc("5328435");
        movie.setScrnCnt("697");
        movie.setShowCnt("3223");
        return movie;
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insert(@RequestBody MovieVO movieVO) {
        System.out.println(movieVO);
        return movieService.insert(movieVO);
    }

    @RequestMapping("all")
    @ResponseBody
    public List<MovieVO> all() {
        return movieService.all();
    }
}
