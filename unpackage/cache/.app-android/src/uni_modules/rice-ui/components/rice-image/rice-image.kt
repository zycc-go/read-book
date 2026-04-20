@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI4CF4B90
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
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage
open class GenUniModulesRiceUiComponentsRiceImageRiceImage : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var src: String by `$props`
    open var mode: String by `$props`
    open var width: Any? by `$props`
    open var height: Any? by `$props`
    open var round: Boolean? by `$props`
    open var radius: Any? by `$props`
    open var showError: Boolean by `$props`
    open var showLoading: Boolean by `$props`
    open var errorIcon: String by `$props`
    open var loadingIcon: String by `$props`
    open var iconSize: String by `$props`
    open var iconColor: String? by `$props`
    open var bgColor: String? by `$props`
    open var preview: Boolean by `$props`
    open var previewSrcList: UTSArray<String>? by `$props`
    open var previewIndex: Number? by `$props`
    open var lazyLoad: Boolean by `$props`
    open var fadeShow: Boolean by `$props`
    open var webp: Boolean by `$props`
    open var showMenuByLongpress: Boolean by `$props`
    open var draggable: Boolean by `$props`
    open var customStyle: UTSJSONObject by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesRiceUiComponentsRiceImageRiceImage) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesRiceUiComponentsRiceImageRiceImage
            val _cache = __ins.renderCache
            val ns = useNamespace("image")
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val _iconColor = computed<String>(fun(): String {
                return props.iconColor ?: (if (isDark.value) {
                    "#8d9095"
                } else {
                    "#dcdee0"
                }
                )
            }
            )
            val error = ref(false)
            val loading = ref(true)
            watch(fun(): String? {
                return props.src
            }
            , fun(){
                error.value = false
                loading.value = true
            }
            )
            val handleLoad = fun(event: UniImageLoadEvent){
                error.value = false
                if (loading.value) {
                    loading.value = false
                    emit("load", event)
                }
            }
            val handleError = fun(event: UniImageErrorEvent){
                error.value = true
                loading.value = false
                emit("error", event)
            }
            val handleClick = fun(){
                if (loading.value || error.value) {
                    return
                }
                val hasPreviewList = UTSArray.isArray(props.previewSrcList) && props.previewSrcList!!.length > 0
                if (props.preview || hasPreviewList) {
                    val urls = if (hasPreviewList) {
                        props.previewSrcList!!
                    } else {
                        _uA(
                            props.src
                        )
                    }
                    var current = props.previewIndex ?: urls.findIndex(fun(v): Boolean {
                        return v == props.src
                    }
                    )
                    current = clamp(current, 0, urls.length - 1)
                    console.log("current", current, " at uni_modules/rice-ui/components/rice-image/rice-image.uvue:109")
                    uni_previewImage(PreviewImageOptions(urls = urls, current = current))
                    return
                }
                emit("click")
            }
            val imageStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.height != null) {
                    css.set("height", addUnit(props.height!!))
                }
                if (props.width != null) {
                    css.set("width", addUnit(props.width!!))
                }
                if (props.radius != null) {
                    css.set("border-radius", addUnit(props.radius!!))
                }
                if (props.bgColor != null) {
                    css.set("background-color", props.bgColor!!)
                }
                return css
            }
            )
            val imgStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.radius != null) {
                    css.set("border-radius", addUnit(props.radius!!))
                }
                return css
            }
            )
            val imageClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.b(""),
                    ns.theme(),
                    ns.`is`("round", props.round == true)
                )
            }
            )
            val imgClass = computed(fun(): UTSArray<String> {
                return _uA(
                    ns.e("img"),
                    ns.`is`("round", props.round == true)
                )
            }
            )
            return fun(): Any? {
                val _component_rice_icon = resolveEasyComponent("rice-icon", GenUniModulesRiceUiComponentsRiceIconRiceIconClass)
                return _cE("view", _uM("class" to _nC(unref(imageClass)), "style" to _nS(_uA(
                    unref(imageStyle),
                    _ctx.customStyle
                )), "onClick" to handleClick), _uA(
                    if (isTrue(unref(error))) {
                        _cE("view", _uM("key" to 0, "class" to _nC(unref(ns).e("error"))), _uA(
                            renderSlot(_ctx.`$slots`, "error", _uO(), fun(): UTSArray<Any> {
                                return _uA(
                                    if (isTrue(_ctx.showError)) {
                                        _cV(_component_rice_icon, _uM("key" to 0, "name" to _ctx.errorIcon, "size" to _ctx.iconSize, "color" to unref(_iconColor)), null, 8, _uA(
                                            "name",
                                            "size",
                                            "color"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )
                            })
                        ), 2)
                    } else {
                        _cE("image", _uM("key" to 1, "class" to _nC(unref(imgClass)), "src" to _ctx.src, "mode" to _ctx.mode, "lazyLoad" to _ctx.lazyLoad, "fadeShow" to _ctx.fadeShow, "webp" to _ctx.webp, "showMenuByLongpress" to _ctx.showMenuByLongpress, "draggable" to _ctx.draggable, "style" to _nS(unref(imgStyle)), "onLoad" to handleLoad, "onError" to handleError), null, 46, _uA(
                            "src",
                            "mode",
                            "lazyLoad",
                            "fadeShow",
                            "webp",
                            "showMenuByLongpress",
                            "draggable"
                        ))
                    }
                    ,
                    if (isTrue(unref(loading))) {
                        _cE("view", _uM("key" to 2, "class" to _nC(unref(ns).e("loading"))), _uA(
                            renderSlot(_ctx.`$slots`, "loading", _uO(), fun(): UTSArray<Any> {
                                return _uA(
                                    if (isTrue(_ctx.showLoading)) {
                                        _cV(_component_rice_icon, _uM("key" to 0, "name" to _ctx.loadingIcon, "size" to _ctx.iconSize, "color" to unref(_iconColor)), null, 8, _uA(
                                            "name",
                                            "size",
                                            "color"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )
                            })
                        ), 2)
                    } else {
                        _cC("v-if", true)
                    }
                ), 6)
            }
        }
        var name = "rice-image"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-image" to _pS(_uM("position" to "relative")), "rice-image__img" to _pS(_uM("height" to "100%", "width" to "100%")), "rice-image--round" to _pS(_uM("borderTopLeftRadius" to 999, "borderTopRightRadius" to 999, "borderBottomRightRadius" to 999, "borderBottomLeftRadius" to 999)), "rice-image__loading" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "height" to "100%", "alignItems" to "center", "justifyContent" to "center", "backgroundImage" to "none", "backgroundColor" to "var(--rice-image-placeholder-background)")), "rice-image__error" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "width" to "100%", "height" to "100%", "alignItems" to "center", "justifyContent" to "center", "backgroundImage" to "none", "backgroundColor" to "var(--rice-image-placeholder-background)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null, "load" to null, "error" to null)
        var props = _nP(_uM("src" to _uM("type" to "String", "required" to false, "default" to ""), "mode" to _uM("type" to "String", "required" to false, "default" to "scaleToFill"), "width" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "height" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "round" to _uM("type" to "Boolean", "required" to false), "radius" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "showError" to _uM("type" to "Boolean", "required" to false, "default" to true), "showLoading" to _uM("type" to "Boolean", "required" to false, "default" to true), "errorIcon" to _uM("type" to "String", "required" to false, "default" to "photo-fail"), "loadingIcon" to _uM("type" to "String", "required" to false, "default" to "photo"), "iconSize" to _uM("type" to "String", "required" to false, "default" to "30px"), "iconColor" to _uM("type" to "String", "required" to false), "bgColor" to _uM("type" to "String", "required" to false), "preview" to _uM("type" to "Boolean", "required" to false, "default" to false), "previewSrcList" to _uM("type" to "Array", "required" to false), "previewIndex" to _uM("type" to "Number", "required" to false), "lazyLoad" to _uM("type" to "Boolean", "required" to false, "default" to false), "fadeShow" to _uM("type" to "Boolean", "required" to false, "default" to false), "webp" to _uM("type" to "Boolean", "required" to false, "default" to true), "showMenuByLongpress" to _uM("type" to "Boolean", "required" to false, "default" to false), "draggable" to _uM("type" to "Boolean", "required" to false, "default" to false), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (_uO())
        }
        )))
        var propsNeedCastKeys = _uA(
            "src",
            "mode",
            "round",
            "showError",
            "showLoading",
            "errorIcon",
            "loadingIcon",
            "iconSize",
            "preview",
            "lazyLoad",
            "fadeShow",
            "webp",
            "showMenuByLongpress",
            "draggable",
            "customStyle"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
