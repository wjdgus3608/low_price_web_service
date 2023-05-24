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
                <tr>
                    <th scope="row">1</th>
                    <td>userId1</td>
                    <td>홍길동</td>
                    <td>
                        <button class="btn btn-primary btn-sm">승인</button>
                    </td>
                    <td>23.01.01</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>userId2</td>
                    <td>가나다</td>
                    <td>
                        <button class="btn btn-primary btn-sm">승인</button>
                    </td>
                    <td>23.01.01</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>userId3</td>
                    <td>누구지</td>
                    <td>
                        <button v-if="!isApproved" class="btn btn-primary btn-sm" @click="approveUser">승인</button>
                        <div v-if="isApproved">승인완료</div>
                    </td>
                    <td>23.01.01</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
export default {
    data(){
        return{
            isApproved: false
        }
    },
    methods: {
        approveUser(){
            this.isApproved = true;
            console.log(this.isApproved);
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