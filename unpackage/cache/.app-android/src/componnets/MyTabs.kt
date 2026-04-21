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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
open class GenComponnetsMyTabs : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var list: UTSArray<TabOption> by `$props`
    open var shrink: Boolean by `$props`
    open var titleActiveColor: String? by `$props`
    open var titleInactiveColor: String? by `$props`
    open var bgColor: String? by `$props`
    open var height: Any? by `$props`
    open var lineColor: String? by `$props`
    open var lineWidth: Any by `$props`
    open var lineHeight: Any? by `$props`
    open var itemStyle: UTSJSONObject by `$props`
    open var activeStyle: UTSJSONObject by `$props`
    open var inactiveStyle: UTSJSONObject by `$props`
    open var customStyle: UTSJSONObject by `$props`
    open var modelValue: Number by `$props`
    open var resize: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["resize"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "resize", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponnetsMyTabs, __setupCtx: SetupContext) -> Any? = fun(__props, __setupCtx): Any? {
            val __expose = __setupCtx.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponnetsMyTabs
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val props = __props
            val modelValue = useModel<Number>(__ins.props, "modelValue")
            var lastValue: Number = 0
            val instance = getCurrentInstance()
            val scrollLeft = ref(0)
            val tabScrollRef = shallowRef<UniElement?>(null)
            val indicatorRef = shallowRef<UniElement?>(null)
            val tabsRef = shallowRef<UniElement?>(null)
            val tabsNodeInfo = shallowRef(_uA<Any>())
            val addUnit = fun(value: Any): String {
                if (UTSAndroid.`typeof`(value) === "number") {
                    return (value as Number) + "px"
                }
                return value as String
            }
            val getPxNum = fun(value: Any, defaultVal: Number): Number {
                if (UTSAndroid.`typeof`(value) === "number") {
                    return value as Number
                }
                if (value as String === "100%") {
                    return defaultVal
                }
                val num = parseInt(value as String)
                return if (isNaN(num)) {
                    defaultVal
                } else {
                    num
                }
            }
            val hasStrValue = fun(value: Any): Boolean {
                return value != null && value !== ""
            }
            val updateTabIndicator = fun(reassignedMoveTo: Number?){
                var moveTo = reassignedMoveTo
                if (moveTo == null) {
                    moveTo = 0
                }
                val tabLen = tabsNodeInfo.value.length
                if (moveTo < 0 || moveTo >= tabLen) {
                    return
                }
                val moveToRect = tabsNodeInfo.value[moveTo]
                val moveToWidth = moveToRect?.width ?: 0
                if (tabLen <= 0 || moveTo >= tabLen) {
                    return
                }
                val offsetLeft = tabsNodeInfo.value.slice(0, moveTo).reduce(fun(cur, pre): Any {
                    return cur + (pre?.width ?: 0)
                }
                , 0)
                var lineWidth = getPxNum(props.lineWidth!!, moveToWidth)
                indicatorRef.value?.style?.setProperty("width", lineWidth + "px")
                var x = offsetLeft + (moveToWidth - lineWidth) / 2
                indicatorRef.value?.style?.setProperty("transform", "translateX(" + x + "px)")
                tabScrollRef.value?.getBoundingClientRectAsync()?.then(fun(res: DOMRect){
                    scrollLeft.value = x - res.width / 2
                }
                )
            }
            val resize = fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        await(nextTick())
                        uni_createSelectorQuery().`in`(instance).selectAll(".my-tabs__item").boundingClientRect(fun(res){
                            val nodeInfoArr = res as UTSArray<Any>
                            tabsNodeInfo.value = nodeInfoArr
                            updateTabIndicator(modelValue.value)
                        }
                        ).exec()
                })
            }
            val tabsItemClick = fun(tab: TabOption, index: Number){
                emit("clickTab", TabClickEvent(index = index, name = tab.name, value = tab.value, disabled = tab.disabled ?: false))
                if (modelValue.value == index || tab.disabled == true) {
                    return
                }
                modelValue.value = index
                lastValue = index
                emit("change", TabChangeEvent(index = index, name = tab.name, value = tab.value, disabled = tab.disabled ?: false))
                updateTabIndicator(index)
            }
            watch(modelValue, fun(newVal: Number){
                if (lastValue != newVal) {
                    lastValue = newVal
                    updateTabIndicator(newVal)
                }
            }
            )
            watch(_uA(
                fun(){
                    return props.lineWidth
                }
                ,
                fun(){
                    return props.lineHeight
                }
                ,
                fun(){
                    return props.list
                }
            ), fun(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        await(nextTick())
                        resize()
                })
            }
            , WatchOptions(deep = true))
            val tabsStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.height != null) {
                    css.set("height", addUnit(props.height!!))
                }
                if (hasStrValue(props.bgColor)) {
                    css.set("background-color", props.bgColor!!)
                }
                return css
            }
            )
            val getTextStyle = fun(tab: TabOption, index: Number): Map<String, String> {
                val textCss = Map<String, String>()
                if (props.itemStyle) {
                    for(key in resolveUTSKeyIterator(props.itemStyle)){
                        textCss.set(key, props.itemStyle!![key] as String)
                    }
                }
                if (modelValue.value == index) {
                    if (props.activeStyle) {
                        for(key in resolveUTSKeyIterator(props.activeStyle)){
                            textCss.set(key, props.activeStyle!![key] as String)
                        }
                    }
                    if (hasStrValue(props.titleActiveColor)) {
                        textCss.set("color", props.titleActiveColor!!)
                    }
                } else {
                    if (props.inactiveStyle) {
                        for(key in resolveUTSKeyIterator(props.inactiveStyle)){
                            textCss.set(key, props.inactiveStyle!![key] as String)
                        }
                    }
                    if (hasStrValue(props.titleInactiveColor) && tab.disabled != true) {
                        textCss.set("color", props.titleInactiveColor!!)
                    }
                }
                return textCss
            }
            val indicatorStyle = computed(fun(): Map<String, String> {
                val css = Map<String, String>()
                if (props.lineHeight != null) {
                    css.set("height", addUnit(props.lineHeight!!))
                }
                if (hasStrValue(props.lineColor)) {
                    css.set("background-color", props.lineColor!!)
                }
                return css
            }
            )
            val tabsClass = computed(fun(): UTSArray<String> {
                return _uA(
                    "my-tabs"
                )
            }
            )
            val tabsItemClass = computed(fun(): UTSArray<String> {
                return _uA(
                    "my-tabs__item",
                    if (props.shrink) {
                        "my-tabs__item--shrink"
                    } else {
                        ""
                    }
                )
            }
            )
            onMounted(fun(){
                resize()
            }
            )
            __expose(_uM("resize" to resize))
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(unref(tabsClass)), "style" to _nS(_uA(
                    unref(tabsStyle),
                    _ctx.customStyle
                )), "ref_key" to "tabsRef", "ref" to tabsRef), _uA(
                    _cE("scroll-view", _uM("ref_key" to "tabScrollRef", "ref" to tabScrollRef, "class" to "my-tabs__scroll", "direction" to "horizontal", "show-scrollbar" to false, "scroll-left" to unref(scrollLeft), "scroll-with-animation" to "true"), _uA(
                        _cE("view", _uM("class" to "my-tabs__scroll-inner"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(_ctx.list, fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("key" to item.name, "class" to _nC(unref(tabsItemClass)), "data-name" to item.name, "onClick" to fun(){
                                    tabsItemClick(item, index)
                                }
                                ), _uA(
                                    if (isTrue(item.badge)) {
                                        _cE("view", _uM("key" to 0, "class" to "my-tabs__badge"), _uA(
                                            if (isTrue(item.badge.isDot)) {
                                                _cE("text", _uM("key" to 0, "class" to "my-tabs__badge-dot"))
                                            } else {
                                                if (isTrue(item.badge.value)) {
                                                    _cE("text", _uM("key" to 1, "class" to "my-tabs__badge-value"), _tD(item.badge.value), 1)
                                                } else {
                                                    _cC("v-if", true)
                                                }
                                            }
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    _cE("text", _uM("style" to _nS(getTextStyle(item, index)), "class" to _nC(_uA(
                                        "my-tabs__item__text",
                                        _uM("my-tabs__item__active" to (index == modelValue.value), "my-tabs__item__disabled" to item.disabled)
                                    ))), _tD(item.name), 7)
                                ), 10, _uA(
                                    "data-name",
                                    "onClick"
                                ))
                            }
                            ), 128),
                            _cE("view", _uM("ref_key" to "indicatorRef", "ref" to indicatorRef, "style" to _nS(unref(indicatorStyle)), "class" to "my-tabs__indicator"), null, 4)
                        ))
                    ), 8, _uA(
                        "scroll-left"
                    ))
                ), 6)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("my-tabs" to _pS(_uM("display" to "flex", "flexDirection" to "row", "height" to 44, "backgroundColor" to "var(--rice-tabs-background, #f5f5f5)")), "my-tabs__scroll" to _pS(_uM("position" to "relative", "display" to "flex", "flexDirection" to "row", "height" to "100%", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "overflow" to "hidden")), "my-tabs__scroll-inner" to _pS(_uM("position" to "relative", "flexGrow" to 1, "flexShrink" to 1, "flexBasis" to "0%", "height" to "100%", "display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "my-tabs__item" to _pS(_uM("position" to "relative", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "paddingTop" to 0, "paddingRight" to 12, "paddingBottom" to 0, "paddingLeft" to 12, "flexGrow" to 1, "flexShrink" to 0, "flexBasis" to "auto", "overflow" to "visible", "cursor" to "pointer")), "my-tabs__item--shrink" to _pS(_uM("paddingTop" to 0, "paddingRight" to 8, "paddingBottom" to 0, "paddingLeft" to 8, "flexGrow" to 0, "flexShrink" to 0, "flexBasis" to "auto")), "my-tabs__item__text" to _pS(_uM("transitionProperty" to "color", "transitionDuration" to "0.3s", "fontSize" to "var(--rice-font-size-basic, 14px)", "color" to "var(--rice-text-color-2, #666)")), "my-tabs__item__active" to _pS(_uM("color" to "var(--rice-text-color, #333)", "fontWeight" to "500")), "my-tabs__item__disabled" to _pS(_uM("color" to "var(--rice-tabs-disabled-text-color, #ccc)", "cursor" to "not-allowed")), "my-tabs__badge" to _pS(_uM("position" to "absolute", "top" to -4, "right" to -4, "zIndex" to 1)), "my-tabs__badge-dot" to _pS(_uM("width" to 6, "height" to 6, "borderTopLeftRadius" to "50%", "borderTopRightRadius" to "50%", "borderBottomRightRadius" to "50%", "borderBottomLeftRadius" to "50%", "backgroundColor" to "var(--rice-color-primary, #d81e06)")), "my-tabs__badge-value" to _pS(_uM("minWidth" to 16, "height" to 16, "paddingTop" to 0, "paddingRight" to 4, "paddingBottom" to 0, "paddingLeft" to 4, "borderTopLeftRadius" to 8, "borderTopRightRadius" to 8, "borderBottomRightRadius" to 8, "borderBottomLeftRadius" to 8, "backgroundColor" to "var(--rice-color-primary, #d81e06)", "color" to "#FFFFFF", "fontSize" to 10, "lineHeight" to "16px", "textAlign" to "center")), "my-tabs__indicator" to _pS(_uM("position" to "absolute", "zIndex" to 1, "bottom" to 2, "left" to 0, "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100, "transitionProperty" to "transform,width", "transitionDuration" to "300ms", "width" to 20, "height" to 3, "backgroundColor" to "var(--rice-color-primary, #d81e06)")), "@TRANSITION" to _uM("my-tabs__item__text" to _uM("property" to "color", "duration" to "0.3s"), "my-tabs__indicator" to _uM("property" to "transform,width", "duration" to "300ms")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("clickTab" to null, "change" to null, "update:modelValue" to null)
        var props = _nP(_uM("list" to _uM("type" to "Array", "required" to true, "default" to fun(): UTSArray<TabOption> {
            return _uA<TabOption>()
        }
        ), "shrink" to _uM("type" to "Boolean", "required" to false, "default" to false), "titleActiveColor" to _uM("type" to "String", "required" to false), "titleInactiveColor" to _uM("type" to "String", "required" to false), "bgColor" to _uM("type" to "String", "required" to false), "height" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "lineColor" to _uM("type" to "String", "required" to false), "lineWidth" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false, "default" to fun(): String {
            return "20px"
        }
        ), "lineHeight" to _uM("type" to _uA(
            "String",
            "Number"
        ), "required" to false), "itemStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (_uO())
        }
        ), "activeStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (_uO())
        }
        ), "inactiveStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (_uO())
        }
        ), "customStyle" to _uM("type" to "UTSJSONObject", "required" to false, "default" to fun(): UTSJSONObject {
            return (_uO())
        }
        ), "modelValue" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "list",
            "shrink",
            "lineWidth",
            "itemStyle",
            "activeStyle",
            "inactiveStyle",
            "customStyle",
            "modelValue"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
