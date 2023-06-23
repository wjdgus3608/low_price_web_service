<template>
    <div id="adminSubPage">
        <h3>승인 관리</h3>
        <br><br>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">이름</th>
                    <th scope="col">상태</th>
                    <th scope="col">신청일시</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(user, index) in users" :key="index">
                    <th scope="row">{{ index+1 }}</th>
                    <td>{{user.userId}}</td>
                    <td>{{user.userName}}</td>
                    <td>
                        <button v-if="user.state==='WAIT'" class="btn btn-primary btn-sm" @click="approveUser(user)">승인</button>
                        <div v-if="user.state==='ACCEPTED'">승인완료</div>
                    </td>
                    <td>{{ user.createdAt }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import axios from "axios"

export default {
    created(){
        this.callAllUsers();
    },
    data(){
        return{
            users:''
        }
    },
    methods: {
        approveUser(user){
            this.callApproveUser(user.userId);
            user.state = 'ACCEPTED';
            
        },
        callAllUsers(){
            axios.get('http://localhost:6060/users')
                .then((response) => {
                    this.users = response.data;
                })
                .catch(error => {
                    console.error(error);
                });
        },
        callApproveUser(userId){
            axios.post('http://localhost:6060/user/approval',{
                userId: userId
            })
                .then(() => {
                    console.log("승인 완료");
                })
                .catch(error => {
                    console.error(error);
                });
        }
    }
}
</script>

<style scoped>
#adminSubPage {
    padding: 0 40px;
}
.table {
    width: 100%;
    height: 100%;
}
</style>