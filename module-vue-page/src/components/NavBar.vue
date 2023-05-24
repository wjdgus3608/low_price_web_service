<template>
    <div id="NavBar">
        <nav class="navbar fixed-top navbar-dark bg-primary justify-content-end">
            <div id="searchBarContainer">
                <SearchBar/>
            </div>
            <a class="navbar-brand" href="#">
                <img src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24"
                    class="d-inline-block align-text-top">
                OOO 님
            </a>
            <button class="btn btn-outline-success me-2 text-white border-white btn-sm" type="button">로그아웃</button>
        </nav>
    </div>
</template>

<script>
import SearchBar from './SearchBar.vue';
export default {
    components:{
        SearchBar
    }
}
</script>

<style scoped>
#searchBarContainer{
    margin-right: 50px;
}
</style>