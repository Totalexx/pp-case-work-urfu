import { createApp } from 'vue'
import App from './App.vue'
import router from "@/router/Router.ts";

const app = createApp(App)

app.config.compilerOptions.comments = false
app.config.globalProperties.backendURL = 'http://localhost:8081'

app.use(router)
app.mount("#app")