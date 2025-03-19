import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'

const app = createApp(App)

app.config.compilerOptions.comments = false
app.config.globalProperties.backendURL = 'http://localhost:8081'

app.use(router)
app.mount("#app")