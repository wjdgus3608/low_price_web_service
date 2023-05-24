<template>
    <div id="keywordsSubPage">
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
    display: flex;
    padding: 0 40px;
}
</style>