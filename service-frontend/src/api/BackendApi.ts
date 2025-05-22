import HTTP from "@/api/Axios.ts";

class BackendApiUtils {
    User=  {
        async isAuthorized() {
            return await HTTP.get('api/v1/auth/check', {withCredentials: true})
        },
        async login(credits) {
            return await HTTP.post('api/v1/login', new URLSearchParams(credits),{withCredentials: true, headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
        },
        async logout() {
            return await HTTP.post('api/v1/logout', null,{withCredentials: true})
        },
    }
    Vacancy = {
        async getAll(filter) {
            return HTTP.get('api/v1/vacancy/get/filter',
                {params: filter, withCredentials: true, headers: {'Content-Type': 'application/json'}})
        },
        async get(id) {
            return HTTP.get('api/v1/vacancy/get/' + id,
                {withCredentials: true})
        },
        async getAllResponses() {
            return HTTP.get('api/v1/vacancy/response/get/all',
                {withCredentials: true})
        },
        async addResponse(response) {
            return HTTP.post('api/v1/vacancy/response/add',
                response,
                {withCredentials: true, headers: {'Content-Type': 'application/json'}})
        },
        async deleteResponse(id) {
            return HTTP.delete('api/v1/vacancy/response/delete',
                {id: id},
                {withCredentials: true, headers: {'Content-Type': 'application/json'}})
        }
    }
    Resume = {
        async getAll() {
            return HTTP.get('api/v1/resume/get/all',
                {withCredentials: true})
        },
        async get(id) {
            return HTTP.get('api/v1/resume/get/' + id,
                {withCredentials: true})
        },
        async create(resume) {
            return HTTP.post('api/v1/resume/create',
                resume,
                {withCredentials: true, headers: {'Content-Type': 'application/json'}})
        },
        async update(resume) {
            return HTTP.put('api/v1/resume/update',
                JSON.stringify(resume),
                {withCredentials: true, headers: {'Content-Type': 'application/json'}})
        },
        async delete(id) {
            return HTTP.delete('api/v1/resume/delete/' + id,
                {withCredentials: true})
        },
    }
}

export default new BackendApiUtils();