<template>
    <div id="itemListPage">
        <NavBar/>
            <div id="leftSideContainer">leftSideContainer</div>
            <div id="middleSideContainer">
                <ItemCard/>
                <ItemCard/>
                <ItemCard/>
                <ItemCard/>
                <ItemCard/>
                <ItemCard/>
                <ItemCard/>
                <ItemCard/>
                <ItemCard/>
                <ItemCard/>
                <ItemCard/>
            </div>
            <div id="rightSideContainer">
                rightSideContainer
                <div id="compareCartContainer">
                    <span style="font-size: medium">비교 바구니</span>
                    <button id="cartClearBtn" class="btn btn-primary btn-sm">전체 비우기</button>
                    <CompareCart/>
                </div>
            </div>
    </div>
</template>

<script>
import NavBar from './NavBar.vue'; 
import ItemCard from './ItemCard.vue'
import CompareCart from './CompareCart.vue';
export default {
    components:{
        NavBar,
        ItemCard,
        CompareCart
    }
}
</script>

<style scoped>
#itemListPage {
    display: flex;
    justify-content: center;
    overflow: hidden;
    margin: 70px 30px;
}
#leftSideContainer {
    width: 100%;
    max-width: 100px;
}
#middleSideContainer {
    width: 100%;
    max-width: 750px;
}
#rightSideContainer {
    display: flex;
    width: 100%;
    max-width: 300px;
    margin-left: 20px;
    background-color: blue;
    
}
#compareCartContainer {
    position: fixed;
    background-color: pink;
    width: 100%;
    max-width: 300px;
    height: 600px;
}
#cartClearBtn{
    float: right;
    font-size: small;

}
</style>