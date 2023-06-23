import { createApp } from 'vue'
import App from './App.vue'
import router from "./router/router"
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"

const app = createApp(App);
app.use(router);

app.config.globalProperties.$getUserBaseUrl = function () {
    return 'http://localhost:6301';
};

app.config.globalProperties.$getFilterKeywordBaseUrl = function () {
    return 'http://localhost:6301';
};

app.mount('#app');



