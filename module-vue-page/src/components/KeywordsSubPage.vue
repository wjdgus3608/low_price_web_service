<template>
    <div id="keywordsSubPage">
        <h3>키워드 관리</h3>
        <br><br>
        <div class="row row-cols-3">
            <div class="col" v-for="(filterKeyword, index) in filterKeywords" :key="index">
                <KeywordCard :filterKeyword="filterKeyword"/>
            </div>
            <!-- <div class="col">
                <KeywordCard />
            </div>
            <div class="col">
                <KeywordCard />
            </div>
            <div class="col">
                <KeywordCard />
            </div>
            <div class="col">
                <KeywordCard />
            </div> -->
        </div>
    </div>
</template>

<script>
import KeywordCard from './KeywordCard.vue';
import axios from 'axios';

export default {
    props:['loginUser','sessionValue'],
    created(){
        this.callGetKeywords(this.loginUser.userId);
    },
    data(){
        return{
            filterKeywords:''
        }
    },
    components: {
        KeywordCard
    },
    methods:{
        callGetKeywords(userId){
            axios.get(this.$getFilterKeywordBaseUrl()+'/filter-keywords/'+userId)
                .then((response) => {
                    console.log("필터키워드 로드 성공");
                    this.filterKeywords = response.data;
                })
                .catch(error => {
                    console.error(error);
                });
        },
    }
    
}
</script>

<style scoped>
#keywordsSubPage {
    padding: 0 40px;

}
</style>