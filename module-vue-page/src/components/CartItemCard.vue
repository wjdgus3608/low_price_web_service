<template>
    <div id="cartItemCard">
        <div class="card" style="flex-grow: 1;">
            <div id="cartItemImgContainer">
                <img src="../assets/sampleImg.jpg" class="card-img-top">
            </div>
            <div class="card-body">
                <h5 class="card-title" id="cartItemTitle">상품명</h5>
                <p class="card-text" id="cartItemPrice">140,000원</p>
                <p class="card-text" id="cartItemDes">상품설명</p>
                <p class="card-text" id="cartItemBrand"><small class="text-muted">브랜드</small></p>
            </div>
            <div id="cartItemToolContainer">
                <button class="btn btn-primary btn-close"></button>
            </div>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
#cartItemCard {
    display: flex;
    padding: 5px;
}

#cartItemImgContainer {
    display: flex;
    justify-content: center;
}

#cartItemToolContainer {
    position: absolute;
    top: 0;
    right: 0;

}


img {
    width: 130px;
    height: 130px;
}
</style>