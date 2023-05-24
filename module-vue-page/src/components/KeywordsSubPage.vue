<template>
    <div id="keywordsSubPage">
        <h3>키워드 관리</h3>
        <br><br>
        <div class="row row-cols-3">
            <div class="col">
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
            </div>
        </div>
    </div>
</template>

<script>
import KeywordCard from './KeywordCard.vue';
export default {
    components: {
        KeywordCard
    }
    
}
</script>

<style scoped>
#keywordsSubPage {
    padding: 0 40px;
    flex-grow: 1;

}
</style>