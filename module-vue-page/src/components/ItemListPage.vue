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
                <div id="compareCartTest">
                    compareCartView
                </div>
            </div>
    </div>
</template>

<script>
import NavBar from './NavBar.vue'; 
import ItemCard from './ItemCard.vue'
export default {
    components:{
        NavBar,
        ItemCard
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
    background-color: blue;
    
}
#compareCartTest {
    position: fixed;
    background-color: pink;
    width: 100%;
    max-width: 300px;
    height: 600px;
}
</style>