@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
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
open class GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var src: String? by `$props`
    open var round: Boolean by `$props`
    open var radius: Any? by `$props`
    open var size: Any? by `$props`
    open var mode: String by `$props`
    open var text: Any? by `$props`
    open var icon: String? by `$props`
    open var bgColor: String? by `$props`
    open var color: String by `$props`
    open var fontSize: Any? by `$props`
    open var defaultUrl: String? by `$props`
    open var customStyle: UTSJSONObject by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesRiceUiComponentsRiceAvatarRiceAvatar
            val _cache = __ins.renderCache
            val base64Avatar = "data:image/jpg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAAA8AAD/4QMraHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjMtYzAxMSA2Ni4xNDU2NjEsIDIwMTIvMDIvMDYtMTQ6NTY6MjcgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDUzYgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjREMEQwRkY0RjgwNDExRUE5OTY2RDgxODY3NkJFODMxIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjREMEQwRkY1RjgwNDExRUE5OTY2RDgxODY3NkJFODMxIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NEQwRDBGRjJGODA0MTFFQTk5NjZEODE4Njc2QkU4MzEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6NEQwRDBGRjNGODA0MTFFQTk5NjZEODE4Njc2QkU4MzEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7/7gAOQWRvYmUAZMAAAAAB/9sAhAAGBAQEBQQGBQUGCQYFBgkLCAYG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"
            val ns = useNamespace("avatar")
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val isLoading = ref(true)
            val avatarUrl = ref<String?>(props.src)
            val textSize = computed(fun(): String {
                if (hasStrValue(props.fontSize)) {
                    return addUnit(props.fontSize!!)
                }
                if (props.size == "large" || props.size == "mini") {
                    return if (props.size as String == "large") {
                        "20px"
                    } else {
                        "14px"
                    }
                }
                return "16px"
            }
            )
            val loadError = fun(event: UniImageErrorEvent?){
                isLoading.value = false
                avatarUrl.value = if (hasStrValue(props.defaultUrl)) {
                    props.defaultUrl
                } else {
                    base64Avatar
                }
                emit("error", event)
            }
            val onImageLoad = fun(){
                isLoading.value = false
            }
            watch(fun(): String? {
                return props.src
            }
            , fun(newVal: String?){
                avatarUrl.value = newVal
                if (!hasStrValue(newVal)) {
                    loadError(null)
                }
            }
            , WatchOptions(immediate = true))
            val handleClick = fun(){
                emit("click")
            }
            val avatarStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (hasStrValue(props.size) && props.size != "large" && props.size != "mini") {
                    val size = addUnit(props.size!!)
                    css.set("width", size)
                    css.set("height", size)
                }
                if (props.bgColor != null) {
                    css.set("background", props.bgColor!!)
                }
                if (hasStrValue(props.radius)) {
                    css.set("border-radius", addUnit(props.radius!!))
                }
                return css
            }
            )
            val imageStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (hasStrValue(props.radius)) {
                    css.set("border-radius", addUnit(props.radius!!))
                }
                return css
            }
            )
            val textStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                css.set("font-size", textSize.value)
                css.set("color", props.color)
                return css
            }
            )
            val avatarClass = computed(fun(): UTSArray<String> {
                val cls = _uA(
                    ns.b(""),
                    ns.`is`("round", props.round && !hasStrValue(props.radius)),
                    ns.`is`("text", hasStrValue(props.text) || hasStrValue(props.icon)),
                    ns.theme()
                )
                if (props.size == "large" || props.size == "mini") {
                    cls.push(ns.m(props.size as String))
                }
                return cls
            }
            )
            val imageClass = computed(fun(): UTSArray<String> {
                val cls = _uA(
                    ns.e("image"),
                    ns.`is`("round", props.round && !hasStrValue(props.radius)),
                    ns.`is`("loading", isLoading.value)
                )
                if (props.size == "large" || props.size == "mini") {
                    cls.push(ns.e("image--" + props.size as String))
                }
                return cls
            }
            )
            return fun(): Any? {
                val _component_rice_icon = resolveEasyComponent("rice-icon", GenUniModulesRiceUiComponentsRiceIconRiceIconClass)
                return _cE("view", _uM("class" to _nC(unref(avatarClass)), "style" to _nS(_uA(
                    unref(avatarStyle),
                    _ctx.customStyle
                )), "onClick" to handleClick), _uA(
                    renderSlot(_ctx.`$slots`, "default", UTSJSONObject(), fun(): UTSArray<Any> {
                        return _uA(
                            if (isTrue(unref(hasStrValue)(_ctx.icon))) {
                                _cV(_component_rice_icon, _uM("key" to 0, "name" to _ctx.icon, "size" to unref(textSize), "color" to _ctx.color), null, 8, _uA(
                                    "name",
                                    "size",
                                    "color"
                                ))
                            } else {
                                if (isTrue(unref(hasStrValue)(_ctx.text))) {
                                    _cE("text", _uM("key" to 1, "style" to _nS(unref(textStyle))), _tD(_ctx.text), 5)
                                } else {
                                    _cE("image", _uM("key" to 2, "src" to unref(avatarUrl), "mode" to _ctx.mode, "style" to _nS(unref(imageStyle)), "class" to _nC(unref(imageClass)), "onLoad" to onImageLoad, "onError" to loadError), null, 46, _uA(
                                        "src",
                                        "mode"
                                    ))
                                }
                            }
                        )
                    }
                    )
                ), 6)
            }
        }
        var name = "rice-avatar"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("rice-avatar" to _pS(_uM("flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "height" to 48, "width" to 48, "borderTopLeftRadius" to "var(--rice-radius-sm)", "borderTopRightRadius" to "var(--rice-radius-sm)", "borderBottomRightRadius" to "var(--rice-radius-sm)", "borderBottomLeftRadius" to "var(--rice-radius-sm)")), "rice-avatar--round" to _pS(_uM("borderTopLeftRadius" to 999, "borderTopRightRadius" to 999, "borderBottomRightRadius" to 999, "borderBottomLeftRadius" to 999)), "rice-avatar--mini" to _pS(_uM("height" to 40, "width" to 40)), "rice-avatar--large" to _pS(_uM("height" to 62, "width" to 62)), "rice-avatar__image" to _pS(_uM("height" to "100%", "width" to "100%", "borderTopLeftRadius" to "var(--rice-radius-sm)", "borderTopRightRadius" to "var(--rice-radius-sm)", "borderBottomRightRadius" to "var(--rice-radius-sm)", "borderBottomLeftRadius" to "var(--rice-radius-sm)")), "rice-avatar--text" to _pS(_uM("backgroundColor" to "var(--rice-image-placeholder-background)")), "rice-avatar--loading" to _pS(_uM("backgroundColor" to "var(--rice-image-placeholder-background)")), "rice-avatar--error" to _pS(_uM("backgroundColor" to "var(--rice-image-placeholder-background)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("click" to null, "error" to null)
        var props = _nP(_uM("src" to _uM("type" to "String", "required" to false), "round" to _uM("type" to "Boolean", "required" to false, "default" to true), "radius" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "size" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "mode" to _uM("type" to "String", "required" to false, "default" to "scaleToFill"), "text" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "icon" to _uM("type" to "String", "required" to false), "bgColor" to _uM("type" to "String", "required" to false), "color" to _uM("type" to "String", "required" to false, "default" to "#fff"), "fontSize" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "defaultUrl" to _uM("type" to "String", "required" to false), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        )))
        var propsNeedCastKeys = _uA(
            "round",
            "mode",
            "color",
            "customStyle"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
