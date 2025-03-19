import { createRouter, createWebHistory } from "vue-router"

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'Онлайн карты РГО',
            component: Landing
        },
    ]
})

router.beforeEach((to, from, next) => {
    document.title = to.name
    next();
});

export default router