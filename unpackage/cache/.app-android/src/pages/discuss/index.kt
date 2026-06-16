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
open class GenPagesDiscussIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDiscussIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDiscussIndex
            val _cache = __ins.renderCache
            val scrollTop = ref<Number>(0)
            val refresherTriggered = ref<Boolean>(false)
            val discussListC = ref(_uA<DiscussItem>())
            val loadinghandle = ref<Boolean>(false)
            val activeIndex2 = ref(0)
            val listBadge = ref(_uA<BadgeItem>(BadgeItem(name = "推荐", isRender = true, isDot = true), BadgeItem(name = "关注", isRender = false, dotNum = 10), BadgeItem(name = "我的收藏", isRender = false, dotNum = 999), BadgeItem(name = "AI", isRender = false)))
            val activeTab = ref<Number>(0)
            val onClickTab = fun(item: BadgeItem, index: Number){
                if (activeTab.value === index) {
                    listBadge.value[index].isRender = true
                    return
                }
                activeTab.value = index
                if (!listBadge.value[index].isRender) {
                    listBadge.value[index].isRender = true
                }
            }
            val onChangeSwiper = fun(event: UniSwiperChangeEvent){
                activeTab.value = event.detail.current
            }
            val onChangeRender = fun(index: Number){
                listBadge.value[index].isRender = false
            }
            onPageScroll(fun(options: OnPageScrollOptions){
                scrollTop.value = options.scrollTop
            }
            )
            return fun(): Any? {
                val _component_uni_fab_button = resolveEasyComponent("uni-fab-button", GenUniModulesUniFabButtonComponentsUniFabButtonUniFabButtonClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "theme-" + unref(state).appTheme,
                    "page"
                )), "style" to _nS(_uM("paddingTop" to ("" + unref(state).statusBarHeight + "px")))), _uA(
                    _cE("view", _uM("class" to "tabs"), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(listBadge), fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("class" to "tab", "key" to item.name, "onClick" to fun(){
                                onClickTab(item, index)
                            }
                            ), _uA(
                                _cE("text", _uM("class" to _nC(_uM("item-text" to true, "item-text-active" to (unref(activeTab) === index)))), _tD(item.name), 3),
                                if (unref(activeTab) === index) {
                                    _cE("view", _uM("key" to 0, "class" to "tab-indicator"))
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 8, _uA(
                                "onClick"
                            ))
                        }
                        ), 128)
                    )),
                    _cE("swiper", _uM("style" to _nS(_uM("flex" to "1")), "duration" to 200, "current" to unref(activeTab), "onChange" to onChangeSwiper), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(unref(listBadge), fun(item, index, __index, _cached): Any {
                            return _cE("swiper-item", _uM("key" to item.name), _uA(
                                _cV(unref(GenPagesDiscussContentClass), _uM("id" to item.name, "isRender" to item.isRender, "onChangeRender" to fun(){
                                    onChangeRender(index)
                                }
                                ), null, 8, _uA(
                                    "id",
                                    "isRender",
                                    "onChangeRender"
                                ))
                            ))
                        }
                        ), 128)
                    ), 44, _uA(
                        "current"
                    )),
                    _cV(_component_uni_fab_button, _uM("class" to "fab-btn"))
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
                return _uM("page" to _pS(_uM("backgroundColor" to "var(--navbar-background)", "height" to "100%", "width" to "100%")), "tabs" to _pS(_uM("height" to 44, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to 0, "paddingRight" to 4, "paddingBottom" to 0, "paddingLeft" to 4)), "tab" to _uM(".tabs " to _uM("paddingTop" to 0, "paddingRight" to 12, "paddingBottom" to 0, "paddingLeft" to 12, "position" to "relative", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "height" to "100%")), "tab-indicator" to _uM(".tabs " to _uM("width" to 20, "height" to 3, "position" to "absolute", "bottom" to 6, "left" to "50%", "transform" to "translateX(-50%)", "zIndex" to 1, "borderTopLeftRadius" to 100, "borderTopRightRadius" to 100, "borderBottomRightRadius" to 100, "borderBottomLeftRadius" to 100, "backgroundColor" to "var(--primary-color)")), "item-text" to _uM(".tabs " to _uM("color" to "var(--text-color-1)")), "item-text-active" to _uM(".tabs " to _uM("color" to "var(--primary-color)")), "fab-btn" to _pS(_uM("position" to "absolute", "right" to 16, "bottom" to 16)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
