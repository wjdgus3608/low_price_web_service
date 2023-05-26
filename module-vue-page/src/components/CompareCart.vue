<template>
    <div id="compareCart">
        <CartItemCard/>
        <CartItemCard/>
        <CartItemCard/>
        <CartItemCard/>
        <CartItemCard/>
        <CartItemCard/>
    </div>
</template>

<script>
import CartItemCard from './CartItemCard.vue';
export default {
   components:{
    CartItemCard
   }
}
</script>

<style scoped>
#compareCart {
    /* overflow: scroll; */
}

</style>