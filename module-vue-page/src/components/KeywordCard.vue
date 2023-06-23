<template>
    <div id="keywordCard">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">{{ filterKeyword.searchKeyword }}</h5>
            </div>
            <ul class="list-group list-group-flush">
                <li v-for="(excludeKeyword, index) in filterKeyword.keywordList" :key="index" class="list-group-item">{{ excludeKeyword.keyword }}</li>
            </ul>
            <div class="card-body">
                <a href="#" class="card-link" data-bs-toggle="modal" data-bs-target="#mymodal">더보기</a>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props:['filterKeyword'],
    components:{
    },
    data(){
        return{
            isOpen: false
        }
    },
    methods:{
        
    }
}
</script>

<style scoped>
#keywordCard {
    display: flex;
    margin-bottom: 30px;
}
</style>