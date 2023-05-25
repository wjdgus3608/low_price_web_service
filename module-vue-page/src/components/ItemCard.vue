<template>
    <div id="itemCard">
        <div id="imgContainer">
            <img src="../assets/sampleImg.jpg" alt="">
        </div>
        <div id="contentsContainer">
            <div id="contents">
                <a href="" id="contentUrl">
                    <h6 id="contentTitle">상품명</h6>
                </a>
                <p id="contentPrice">140,000원</p>
                <p id="contentBrand">브랜드</p>
                <p id="contentDes">상품설명</p>
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

#imgContainer {
    flex-grow: 1;
    background-color: green;
}

#contentsContainer {
    flex-grow: 10;
    background-color: yellow;
}

img {
    width: 140px;
    height: 140px;
    object-fit: contain;
}

#contents {
    padding: 5px;
    display: block;
}</style>