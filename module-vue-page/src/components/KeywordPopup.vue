
<template>
    <div id="keywordPopup">
        <div class="modal fade" id="mymodal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-scrollable">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Keyword</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <ul class="list-group">
                            <li class="list-group-item">
                                <input class="form-check-input me-1" type="checkbox" value="" aria-label="...">
                                First checkbox
                            </li>
                            <li class="list-group-item">
                                <input class="form-check-input me-1" type="checkbox" value="" aria-label="...">
                                Second checkbox
                            </li>
                            <li class="list-group-item">
                                <input class="form-check-input me-1" type="checkbox" value="" aria-label="...">
                                Third checkbox
                            </li>
                            <li class="list-group-item">
                                <input class="form-check-input me-1" type="checkbox" value="" aria-label="...">
                                Fourth checkbox
                            </li>
                            <li class="list-group-item">
                                <input class="form-check-input me-1" type="checkbox" value="" aria-label="...">
                                Fifth checkbox
                            </li>
                        </ul>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary">키워드 추가</button>
                        <button type="button" class="btn btn-danger">선택 삭제</button>
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
#keywordPopup {
    display: flex;
}
</style>