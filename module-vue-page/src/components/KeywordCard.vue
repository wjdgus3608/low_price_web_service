<template>
    <div id="keywordCard">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Keyword</h5>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">제외 키워드1</li>
                <li class="list-group-item">제외 키워드2</li>
                <li class="list-group-item">제외 키워드3</li>
            </ul>
            <div class="card-body">
                <a href="#" class="card-link" data-bs-toggle="modal" data-bs-target="#mymodal">더보기</a>
            </div>
        </div>
    </div>
</template>

<script>
export default {
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