import "bootstrap/dist/css/bootstrap.min.css";
import 'bootstrap-icons/font/bootstrap-icons.css';

import { createApp } from 'vue'
import router from "@/router/Router.ts";
import App from './App.vue'


const app = createApp(App)

app.config.compilerOptions.comments = false
app.config.globalProperties.backendURL = 'http://localhost:8081'

app.use(router)
app.mount("#app")