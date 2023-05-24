<template>
    <div id="searchBar">
        <form id="searchForm">
            <div class="input-group input-group-sm" id="searchInput">
                <input type="text" class="form-control" placeholder="검색어를 입력하세요." aria-label="검색어를 입력하세요."
                    aria-describedby="button-addon2">
                <button class="btn btn-primary" type="button" id="button-addon2" @click="submitForm">검색</button>
            </div>
        </form>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped>

#searchForm {
    display: inline-block;
    width: 700px;
    height: 100%;
}

#signupBtn {
    float: right;
}

</style>