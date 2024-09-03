import api from "@/api";

const BASE_URL = "/api/board";

const headers = { "Content-Type": "multipart/form-data" };

/* 주석 구현 부분
* 요구사항 : getList 라는 비동기 함수로
* 주어진 파라미터 ( 를 사용해 BASE_URL 로 API 요청을
보내고
* 응답받은 데이터를 반환
* 비동기 함수 getList: params 를 받아 API 요청을 보냄
* API 요청 : BASE_URL 로 GET 요청을 보냄
* 응답 처리 : 응답에서 데이터를 추출해 로그로 출력하고 , 그 데이터를
반환
*/
export default {
  async getList(params) {
    const { data } = await api.get(BASE_URL, { params });
    console.log("BOARD GET LIST: ", data);
    return data;
  },

  async get(no) {
    const { data } = await api.get(`${BASE_URL}/${no}`);
    console.log("BOARD GET", data);
    return data;
  },

  async create(article) {
    const formData = new FormData();

    formData.append("title", article.title);
    formData.append("writer", article.writer);
    formData.append("content", article.content);

    if (article.files) {
      for (let i = 0; i < article.files.length; i++) {
        formData.append("files", article.files[i]);
      }
    }

    const { data } = await api.post(BASE_URL, formData, { headers });
    console.log("BOARD POST: ", data);
    return data;
  },

  async update(article) {
    const formData = new FormData();
    formData.append("no", article.no);
    formData.append("title", article.title);
    formData.append("writer", article.writer);
    formData.append("content", article.content);

    if (article.files) {
      for (let i = 0; i < article.files.length; i++) {
        formData.append("files", article.files[i]);
      }
    }

    const { data } = await api.put(`${BASE_URL}/${article.no}`, article, {
      headers,
    });
    console.log("BOARD PUT: ", data);
    return data;
  },

  async delete(no) {
    const { data } = await api.delete(`${BASE_URL}/${no}`);
    console.log("BOARD DELETE: ", data);
    return data;
  },

  async deleteAttachment(no) {
    const { data } = await api.delete(`${BASE_URL}/deleteAttachment/${no}`);
    console.log("ATTACHMENT DELETE: ", data);
    return data;
  },
};
