<template>
    <div id="searchMain">
        <NavBar/>
        <div class="container" id="searchContainer">
            <h3>최저가 검색하기</h3>
            <SearchBar/>
        </div>
    </div>
</template>

<script>
import NavBar from './NavBar.vue'
import SearchBar from './SearchBar.vue'
export default {
    components: {
        NavBar,
        SearchBar
    }
}
</script>

<style scoped>
#searchContainer {
    position: absolute;
    top: 50%;
    left: 50%;
    width: 1000px;
    transform: translate(-50%, -50%);
    text-align: center;
}
</style>