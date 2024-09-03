import { ref, computed, reactive } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

const initState = {
  token: "",
  user: {
    username: "",
    email: "",
    roles: [],
  },
};

export const useAuthStore = defineStore("auth", () => {
  const state = ref({ ...initState });

  const isLogin = computed(() => !!state.value.user.username);

  const username = computed(() => state.value.user.username);
  const email = computed(() => state.value.user.email);

  const load = () => {
    /** 주석 구현 부분
     * localStorage에 저장된 사용자 인증 정보를 불러와서 state에 저장하는 역할의 함수를 구현하시오.
     * 상세 조건 :
     * - localStorage에서 auth라는 항목을 가져와, 그 값이 존재하면 이를 파싱하여 state.value에 저장하는 함수
     * - localStorage.getItem('auth'): localStorage에서 'auth'라는 키에 저장된 값을 가져온다.
     * - if (auth != null): auth 값이 존재하면 (null이 아니면),
     * - state.value = JSON.parse(auth);: auth 문자열을 JSON 객체로 변환한 후 state.value에 할당
     **/
    const auth = localStorage.getItem("auth");
    console.log();
    if (auth != null) {
      state.value = JSON.parse(auth);
    }
  };

  const login = async (member) => {
    /** 주석 구현 부분
     *
     * 로그인 요청을 보내고, 서버로부터 받은 인증 정보를 상태와 localStorage에 저장하는 역할의 함수를 구현하시오.
     * 상세 조건 :
     * - axios.post('/api/auth/login', member): member 정보를 사용해 /api/auth/login API에 로그인 요청을 보냄.
     * - { data } = await axios.post(...): API 요청이 완료되면 서버에서 받은 응답 데이터를 data에 저장
     * - state.value = { ...data };: 받은 데이터를 state.value에 저장
     * - localStorage.setItem('auth', JSON.stringify(state.value));: state.value를 문자열로 변환해 localStorage에 'auth'라는 키로 저장
     *
     **/
    const { data } = await axios.post("/api/auth/login", member);
    state.value = { ...data };
    localStorage.setItem("auth", JSON.stringify(state.value));
  };

  const logout = () => {
    /** 주석 구현 부분
     *
     * 로그아웃 시 저장된 데이터를 지우고, 상태를 초기화하는 역할의 함수를 정의하시오.
     * 상세 조건 :
     * - localStorage.clear(): localStorage에 저장된 모든 데이터를 삭제
     * - state.value = { ...initState };: 애플리케이션의 상태를 초기 상태(initState)로 재설정
     *
     **/
    localStorage.clear();
    state.value = { ...initState };
  };

  const getToken = () => state.value.token;

  const changeProfile = (member) => {
    state.value.user.email = member.email;
    localStorage.setItem("auth", JSON.stringify(state.value));
  };

  load();

  // 토큰을 가져오고, 사용자의 이메일을 업데이트하며, 초기 상태를 불러오는 기능을 수행
  // getToken(): 현재 상태(state.value)에서 token 값을 반환합니다.
  // changeProfile(member): 사용자의 이메일을 주어진 member.email로 변경하고, 변경된 상태를 localStorage에 저장합니다.
  // load(): 페이지가 로드될 때 localStorage에서 저장된 인증 정보를 불러와 state에 설정

  return {
    state,
    username,
    email,
    isLogin,
    changeProfile,
    login,
    logout,
    getToken,
  };
});
