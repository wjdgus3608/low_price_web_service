<template>
    <div id="itemCard">

        <div class="card mb-3">
            <div class="row g-0">
                <div class="col-md-4">
                    <img src="../assets/sampleImg.jpg" class="img-fluid rounded-start">
                </div>
                <div class="col-md-8">
                    <div class="card-body" style="position: relative;">
                        <div id="contents">
                            <a href="" id="contentUrl">
                                <h5 class="card-title" id="contentTitle">상품명</h5>
                            </a>
                            <p class="card-text" id="contentPrice">140,000원</p>
                            <p class="card-text" id="contentDes">상품설명</p>
                            <p class="card-text" id="contentBrand"><small class="text-muted">브랜드</small></p>
                        </div>
                        <div id="itemCardToolContainer">
                            <button class="btn btn-primary btn-sm">
                                <img id="cartImg" src="../assets/cartImg.png" alt="addToCart">
                            </button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
#itemCard {
    display: flex;
    padding: 20px;
    background-color: gray;
}

#itemCardToolContainer {
    position: absolute;
    top: 10px;
    right: 10px;

}

#cartImg {
    width: 20px;
    height: 20px;
    object-fit: contain;
}

/* #contentsContainer {
    flex-grow: 10;
    background-color: yellow;
} */

/* #imgContainer {
    flex-grow: 1;
    background-color: green;
}



img {
    width: 140px;
    height: 140px;
    object-fit: contain;
}

#contents {
    padding: 5px;
    display: block;
} */
</style>