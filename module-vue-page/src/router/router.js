import { createWebHistory, createRouter } from "vue-router";
import LogInPage from "../components/LogInPage";
import SignUpPage from "../components/SignUpPage";
import SearchPage from "../components/SearchPage";
import MyPage from "../components/MyPage";
import ItemListPage from "../components/ItemListPage";
import KeywordPopup from "../components/KeywordPopup";

const router = createRouter({
    history : createWebHistory(),
    routes : [ // path별 component를 추가한다.
        { path : "/", name : "LogInPage", component : LogInPage },
        { path : "/signup-page", name : "SignUpPage", component : SignUpPage },
        { path : "/search-page", name : "SearchPage", component : SearchPage },
        { path : "/my-page", name : "MyPage", component : MyPage },
        { path : "/item-list-page", name : "ItemListPage", component : ItemListPage },
        { path : "/my-page/keyword-popup", name : "KeywordPopup", component : KeywordPopup },
    ]
});

export default router;