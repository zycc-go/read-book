@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI194B5B1
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.unicloud.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import io.dcloud.uniapp.extapi.getStorage as uni_getStorage
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading
import io.dcloud.uniapp.extapi.navigateBack as uni_navigateBack
import io.dcloud.uniapp.extapi.setStorage as uni_setStorage
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading
import io.dcloud.uniapp.extapi.showToast as uni_showToast
open class GenPagesSearchIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesSearchIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesSearchIndex
            val _cache = __ins.renderCache
            val style = computed(fun(): UTSJSONObject {
                return _uO("paddingTop" to (state.statusBarHeight + state.navbarHeight + "px"), "paddingBottom" to (state.safeAreaInsetsHeight + "px"))
            }
            )
            val isFocus = ref<Boolean>(false)
            val keywords = ref<String>("")
            val searchRecord = ref(_uA<SearchRecordItem>())
            val searchType = ref<String>("record")
            val fromType = ref<String>("book")
            val onBack = fun(){
                uni_navigateBack(null)
            }
            val onInput = fun(event: UniInputEvent){
                if (event.detail.value.length == 0) {
                    searchType.value = "record"
                }
            }
            val onInputClear = fun(){
                keywords.value = ""
            }
            val onClickAction = fun(){
                if (keywords.value.length > 0) {
                    searchType.value = "result"
                    if (searchRecord.value.findIndex(fun(item1): Boolean {
                        return item1.text === keywords.value
                    }) < 0) {
                        uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                        searchRecord.value.push(SearchRecordItem(id = getRandomDigits(12), text = keywords.value))
                        uni_setStorage(SetStorageOptions(key = "searchRecord", data = searchRecord.value, complete = fun(_){
                            return uni_hideLoading(null)
                        }
                        ))
                    }
                } else if (searchType.value === "result") {
                    searchType.value = "record"
                } else {
                    uni_showToast(ShowToastOptions(title = "请输入内容", icon = "error"))
                }
            }
            val onSearchItem = fun(item: SearchRecordItem){
                keywords.value = item.text
                onClickAction()
            }
            val onDeleteItem = fun(item: SearchRecordItem){
                searchRecord.value = searchRecord.value.filter(fun(item1): Boolean {
                    return item1.id !== item.id
                }
                )
                uni_setStorage(SetStorageOptions(key = "searchRecord", data = searchRecord.value, fail = fun(err: UniError){
                    console.log(err, " at pages/search/index.uvue:119")
                }
                ))
            }
            val onClearItems = fun(){
                if (searchRecord.value.length > 0) {
                    searchRecord.value = _uA()
                    uni_setStorage(SetStorageOptions(key = "searchRecord", data = searchRecord.value, fail = fun(err: UniError){
                        console.log(err, " at pages/search/index.uvue:131")
                    }
                    ))
                }
            }
            val initData = fun(){
                uni_showLoading(ShowLoadingOptions(title = "加载中..."))
                uni_getStorage(GetStorageOptions(key = "searchRecord", success = fun(res: GetStorageSuccess){
                    val data = UTSAndroid.consoleDebugError(JSON.parse<UTSArray<SearchRecordItem>>(JSON.stringify(res.data)), " at pages/search/index.uvue:142")
                    searchRecord.value = data ?: _uA()
                }
                , complete = fun(_){
                    return uni_hideLoading(null)
                }
                ))
            }
            onLoad(fun(options){
                initData()
                fromType.value = options["type"] ?: "book"
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "theme-" + unref(state).appTheme,
                    "page"
                ))), _uA(
                    _cE("view", _uM("class" to "page-navbar", "style" to _nS(_uM("height" to ("" + unref(state).navbarHeight + "px"), "top" to ("" + unref(state).statusBarHeight + "px")))), _uA(
                        _cE("view", _uM("class" to "page-navbar-left", "onClick" to onBack), _uA(
                            _cV(unref(GenComponnetsMyIconIndexClass), _uM("name" to "left", "size" to "24px"))
                        )),
                        _cE("view", _uM("class" to "input-wrapper"), _uA(
                            _cE("input", _uM("class" to "input", "maxlength" to 100, "modelValue" to unref(keywords), "onInput" to _uA<Any?>(fun(`$event`: UniInputEvent){
                                trySetRefValue(keywords, `$event`.detail.value)
                            }
                            , onInput)), null, 40, _uA(
                                "modelValue"
                            )),
                            if (unref(keywords).length > 0) {
                                _cE("view", _uM("key" to 0, "class" to "input-close", "onClick" to onInputClear), _uA(
                                    _cV(unref(GenComponnetsMyIconIndexClass), _uM("name" to "close", "color" to "var(--text-color-2)"))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        )),
                        _cE("text", _uM("class" to "page-navbar-right", "onClick" to onClickAction), "搜索")
                    ), 4),
                    _cE("view", _uM("class" to "card", "style" to _nS(_uM("paddingTop" to ("" + (unref(state).navbarHeight + unref(state).statusBarHeight) + "px")))), _uA(
                        if (unref(searchType) === "record") {
                            _cE("view", _uM("key" to 0, "class" to "card-title-box"), _uA(
                                _cE("text", _uM("class" to "card-title"), "历史记录"),
                                _cE("view", _uM("class" to "card-clear", "onClick" to onClearItems), _uA(
                                    _cE("text", _uM("class" to "card-clear-text"), "清空"),
                                    _cV(unref(GenComponnetsMyIconIndexClass), _uM("name" to "delete"))
                                ))
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (unref(searchType) === "result") {
                            _cE("view", _uM("key" to 1, "class" to "card-title-box"), _uA(
                                _cE("text", _uM("class" to "card-title"), "搜索结果")
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                    ), 4),
                    _cE("scroll-view", _uM("style" to _nS(_uM("flex" to "1")), "direction" to "vertical", "scroll-with-animation" to "true"), _uA(
                        if (unref(searchRecord).length > 0) {
                            _cE("view", _uM("key" to 0, "class" to "tag-list"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(unref(searchRecord), fun(item, __key, __index, _cached): Any {
                                    return _cE("view", _uM("class" to "tag-box", "onClick" to fun(){
                                        onSearchItem(item)
                                    }), _uA(
                                        _cE("text", _uM("class" to "tag"), _tD(item.text), 1),
                                        _cE("view", _uM("onClick" to withModifiers(fun(){
                                            onDeleteItem(item)
                                        }, _uA(
                                            "stop"
                                        ))), _uA(
                                            _cV(unref(GenComponnetsMyIconIndexClass), _uM("name" to "close"))
                                        ), 8, _uA(
                                            "onClick"
                                        ))
                                    ), 8, _uA(
                                        "onClick"
                                    ))
                                }), 256)
                            ))
                        } else {
                            _cE("view", _uM("key" to 1, "class" to "empty"), _uA(
                                _cE("text", _uM("class" to "text"), "空空如也")
                            ))
                        }
                    ), 4)
                ), 2)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page" to _pS(_uM("backgroundColor" to "var(--navbar-background)", "width" to "100%", "height" to "100%")), "page-navbar" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "position" to "fixed", "width" to "100%", "zIndex" to 99, "backgroundColor" to "var(--navbar-background)")), "page-navbar-left" to _uM(".page-navbar " to _uM("width" to 40, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "icon" to _uM(".page-navbar " to _uM("fontSize" to 24)), "input-wrapper" to _uM(".page-navbar " to _uM("flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center", "paddingTop" to 8, "paddingRight" to 28, "paddingBottom" to 8, "paddingLeft" to 12, "backgroundColor" to "var(--background-color-2)", "borderTopLeftRadius" to 16, "borderTopRightRadius" to 16, "borderBottomRightRadius" to 16, "borderBottomLeftRadius" to 16)), "input" to _uM(".page-navbar .input-wrapper " to _uM("fontSize" to 14)), "input-close" to _uM(".page-navbar .input-wrapper " to _uM("marginLeft" to 4)), "page-navbar-right" to _uM(".page-navbar " to _uM("width" to "120rpx", "textAlign" to "center", "color" to "var(--text-color-1)", "fontSize" to 16)), "card" to _pS(_uM("paddingTop" to 0, "paddingRight" to 16, "paddingBottom" to 0, "paddingLeft" to 16)), "card-title-box" to _uM(".card " to _uM("display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between")), "card-title" to _uM(".card .card-title-box " to _uM("marginTop" to 12, "marginRight" to 0, "marginBottom" to 12, "marginLeft" to 0, "color" to "var(--text-color-2)")), "card-clear" to _uM(".card .card-title-box " to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "card-clear-text" to _uM(".card .card-title-box .card-clear " to _uM("color" to "var(--text-color-2)", "fontSize" to 14, "marginRight" to "4rpx")), "tag-list" to _pS(_uM("display" to "flex", "flexDirection" to "row", "flexWrap" to "wrap", "paddingTop" to 0, "paddingRight" to 16, "paddingBottom" to 0, "paddingLeft" to 16)), "tag-box" to _uM(".tag-list " to _uM("paddingTop" to 4, "paddingRight" to 8, "paddingBottom" to 4, "paddingLeft" to 8, "borderTopLeftRadius" to 4, "borderTopRightRadius" to 4, "borderBottomRightRadius" to 4, "borderBottomLeftRadius" to 4, "backgroundColor" to "var(--background-color-2)", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "marginTop" to 0, "marginRight" to 12, "marginBottom" to 12, "marginLeft" to 0)), "tag" to _uM(".tag-list " to _uM("color" to "var(--text-color-2)", "fontSize" to 14, "marginRight" to 4)), "empty" to _pS(_uM("minHeight" to "200rpx", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "marginTop" to 12, "marginRight" to 16, "marginBottom" to 12, "marginLeft" to 16, "backgroundColor" to "var(--background-color-2)", "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8)), "text" to _uM(".empty " to _uM("color" to "var(--text-color-3)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
