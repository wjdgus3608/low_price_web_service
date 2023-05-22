import { createWebHistory, createRouter } from "vue-router";
import LogIn from "../components/LogIn";
import SignUp from "../components/SignUp";

const router = createRouter({
    history : createWebHistory(),
    routes : [ // path별 component를 추가한다.
        { path : "/", name : "LogIn", component : LogIn },
        { path : "/signup", name : "SignUp", component : SignUp }
        // { path : "/home", name : "HelloWorld", component : HelloWorld }
    ]
});

export default router;