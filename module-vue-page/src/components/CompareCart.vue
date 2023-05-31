<template>
    <div id="compareCart">
        <div id="compareCartItemContainer">
            <CartItemCard />
            <CartItemCard />
            <CartItemCard />
            <CartItemCard />
            <CartItemCard />
            <CartItemCard />
        </div>
        <div id="compareCartToolContainer">
            <select class="form-select form-select-sm" aria-label=".form-select-sm example">
                <option selected>Open this select menu</option>
                <option value="1">One</option>
                <option value="2">Two</option>
                <option value="3">Three</option>
            </select>
        </div>
    </div>
</template>

<script>
import CartItemCard from './CartItemCard.vue';
export default {
    components: {
        CartItemCard
    }
}
</script>

<style scoped>

#compareCartItemContainer {
    width: 100%;
    overflow: scroll;
    height: 650px;
}

#compareCartToolContainer {
}
</style>