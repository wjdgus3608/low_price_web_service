<template>
    <div id="myMenu">
        <div class="row">
            <div class="col-4">
                <div class="list-group" id="list-tab" role="tablist">
                    <a class="list-group-item list-group-item-action active" id="list-home-list" data-bs-toggle="list"
                        href="#list-home" role="tab" aria-controls="list-home" @click="clickMenu(0)">키워드 관리</a>
                    <a class="list-group-item list-group-item-action" id="list-profile-list" data-bs-toggle="list"
                        href="#list-profile" role="tab" aria-controls="list-profile" @click="clickMenu(1)">승인 관리</a>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    methods:{
        clickMenu(num){
            this.$parent.$data.menuNum = num;
        }
    }
}
</script>

<style scoped>
.row {
    width: 250px;
}
.col-4 {
    width: 100%;
}
</style>