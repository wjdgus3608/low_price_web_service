import { createWebHistory, createRouter } from "vue-router";
import HelloWorld from "../components/HelloWorld"
const router = createRouter({
    history : createWebHistory(),
    routes : [ // path별 component를 추가한다.
        { path : "/", name : "HelloWorld", component : HelloWorld }
        // { path : "/home", name : "HelloWorld", component : HelloWorld }
    ]
});

export default router;