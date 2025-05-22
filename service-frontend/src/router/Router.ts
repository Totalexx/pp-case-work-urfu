import { createRouter, createWebHistory } from "vue-router"
import VacancySearch from "@/components/student/VacancySearch.vue";
import Login from "@/components/auth/Login.vue";
import Registration from "@/components/auth/Registration.vue";
import StudentMain from "@/components/student/StudentMain.vue";
import Vacancy from "@/components/student/Vacancy.vue";
import Resume from "@/components/student/Resume.vue";
import Profile from "@/components/student/Profile.vue";
import ResumeEdit from "@/components/student/ResumeEdit.vue";
import Responses from "@/components/student/Responses.vue";
import Notifications from "@/components/student/Notifications.vue";
import BackendApi from "@/api/BackendApi";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            component: StudentMain,
            children: [
                {
                    path: '',
                    name: 'Вакансии УрФУ',
                    component: VacancySearch
                },
                {
                    path: 'vacancy/:id',
                    name: 'Вакансия',
                    component: Vacancy,
                    props: true,
                },
                {
                    path: 'resume',
                    children: [
                        {
                            path: '',
                            name: 'Резюме',
                            component: Resume
                        },
                        {
                            path: 'edit/:id',
                            name: 'Редактирование резюме',
                            component: ResumeEdit,
                            props: true,
                        },
                        {
                            path: 'create',
                            name: 'Создать резюме',
                            component: ResumeEdit
                        },
                    ]
                },
                {
                    path: 'profile',
                    name: 'Профиль',
                    component: Profile
                },
                {
                    path: 'responses',
                    name: 'Мои отклики',
                    component: Responses
                },
                {
                    path: 'notifications',
                    name: 'Уведомления',
                    component: Notifications
                }
            ]
        },
        {
            path: '/login',
            name: 'Логин',
            component: Login
        },
        {
            path: '/registration',
            name: 'Регистрация',
            component: Registration
        }
    ]
})

router.beforeEach(async (to, from, next) => {
    if (typeof to.name === "string") {
        document.title = to.name;
    }

    if (to.name !== 'Логин' && to.name !== 'Регистрация') {
        try {
            await BackendApi.User.isAuthorized();
            next();
        } catch (e) {
            next({ name: 'Логин' });
        }
    } else {
        next();
    }
});

export default router