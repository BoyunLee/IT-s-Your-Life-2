<script setup>
import api from "@/api/boardApi";
import { ref, reactive, computed, watch } from "vue";
import moment from "moment";
import { useRoute, useRouter } from "vue-router";

const cr = useRoute();
const router = useRouter();

const page = ref({});

const articles = computed(() => page.value.list);

const pageRequest = reactive({
  page: parseInt(cr.query.page) || 1,
  amount: parseInt(cr.query.amount) || 10,
});

// console.log('QUERY', cr.query);
// console.log('PAGE REQUEST', pageRequest);

// 페이지네이션 페이지 변경
const handlePageChange = async (pageNum) => {
  console.log("CLICK,,,,");
  // url 변경 --> query 파트만 변경되므로 컴포넌트가 다시 마운트되지 않음
  // watch를 통해 cr이 변경됨을 감지하여 페이지 로드해야 함
  router.push({
    query: { page: pageNum, amount: pageRequest.amount },
  });
};

// pageRequest의 값 변경된 경우 호출
watch(cr, async (newValue) => {
  console.log("WATCH", cr.query.page);
  pageRequest.page = parseInt(cr.query.page);
  pageRequest.amount = parseInt(cr.query.amount);
  await load(pageRequest);
});

const load = async (query) => {
  /**  < 주석 구현 부분 시작 >  **/

  //비동기 함수 load: query를 받아서 API 요청을 보냄.
  //API 요청: api.getList(query)를 통해 데이터를 가져옴.
  //데이터 저장: 가져온 데이터를 page.value에 저장.
  //오류 처리: 오류가 발생해도 특별한 처리를 하지 않고 무시.

  /**  <  주석 구현 부분 시작 끝>  **/
  try {
    // API 요청을 통해 데이터를 받아옴
    const response = await api.getList(query);
    // 받아온 데이터를 page.value에 저장
    page.value = response;
  } catch (error) {
    console.error("Failed to load articles:", error);
  }
};

load(pageRequest);
</script>

<template>
  <div>
    <h1 class="mb-3"><i class="fa-solid fa-paste"></i> 게시글 목록</h1>

    <div class="mt-5 text-end">(총 {{ page.totalCount }}건)</div>

    <table class="table table-striped">
      <thead>
        <tr>
          <th style="width: 60px">No</th>
          <th>제목</th>
          <th style="width: 100px">작성자</th>
          <th style="width: 120px">작성일</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="article in articles" :key="article.no">
          <td>{{ article.no }}</td>
          <td>
            <router-link
              :to="{
                name: 'board/detail',
                params: { no: article.no },
                query: cr.query,
              }"
            >
              {{ article.title }}
            </router-link>
          </td>
          <td>{{ article.writer }}</td>
          <td>{{ moment(article.regDate).format("YYYY-MM-DD") }}</td>
        </tr>
      </tbody>
    </table>

    <div class="my-5 d-flex">
      <div class="flex-grow-1 text-center">
        <!-- 페이지 네이션 -->
        <!-- < 주석 구현 부분 시작 > -->
        <vue-awesome-paginate
          :total-items="page.totalCount"
          :items-per-page="pageRequest.amount"
          :max-pages-shown="5"
          :show-ending-buttons="true"
          v-model="pageRequest.page"
          @click="handlePageChange"
        >
          <!-- < 주석 구현 부분 끝> -->
          <template #first-page-button
            ><i class="fa-solid fa-backward-fast"></i
          ></template>
          <template #prev-button
            ><i class="fa-solid fa-caret-left"></i
          ></template>
          <template #next-button
            ><i class="fa-solid fa-caret-right"></i
          ></template>
          <template #last-page-button
            ><i class="fa-solid fa-forward-fast"></i
          ></template>
        </vue-awesome-paginate>
      </div>
      <div>
        <router-link
          :to="{ name: 'board/create', query: cr.query }"
          class="btn btn-primary"
          ><i class="fa-solid fa-pen-to-square"></i> 글 작성</router-link
        >
      </div>
    </div>
  </div>
</template>
