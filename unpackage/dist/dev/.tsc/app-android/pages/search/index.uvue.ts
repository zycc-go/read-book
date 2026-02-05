import _easycom_rice_search from '@/uni_modules/rice-ui/components/rice-search/rice-search.uvue'
import _easycom_rice_navbar from '@/uni_modules/rice-ui/components/rice-navbar/rice-navbar.uvue'
import { setTheme } from "@/uni_modules/rice-ui"
	import { state } from '@/store/index.uts'
	
	
const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const value = ref('')
	
	const onClickAction = () => { }

return (): any | null => {

const _component_rice_search = resolveEasyComponent("rice-search",_easycom_rice_search)
const _component_rice_navbar = resolveEasyComponent("rice-navbar",_easycom_rice_navbar)

  return _cE("view", _uM({
    class: _nC(`rice-theme-${unref(state).appTheme}`)
  }), [
    _cV(_component_rice_navbar, _uM({
      height: unref(state).statusBarHeight
    }), _uM({
      title: withSlotCtx((): any[] => [
        _cE("view", _uM({ class: "nav-right" }), [
          _cV(_component_rice_search, _uM({
            modelValue: unref(value),
            "onUpdate:modelValue": $event => {trySetRefValue(value, $event)},
            placeholder: "请输入搜索关键词"
          }), null, 8 /* PROPS */, ["modelValue"])
        ])
      ]),
      _: 1 /* STABLE */
    }), 8 /* PROPS */, ["height"]),
    _cE("view", _uM({ class: "card" }), " 历史记录 ")
  ], 2 /* CLASS */)
}
}

})
export default __sfc__
const GenPagesSearchIndexStyles = [_uM([["nav-right", _pS(_uM([["display", "flex"], ["flexDirection", "row"], ["marginRight", 15]]))], ["nac-icon", _uM([[".nav-right ", _uM([["fontSize", 26], ["marginLeft", 10]])]])], ["header", _pS(_uM([["marginTop", 12], ["marginRight", 15], ["marginBottom", 12], ["marginLeft", 15], ["display", "flex"], ["flexDirection", "row"]]))], ["h-right", _uM([[".header ", _uM([["marginLeft", 10], ["fontSize", 12], ["display", "flex"], ["justifyContent", "center"]])]])], ["h-text1", _uM([[".header ", _uM([["color", "var(--rice-text-color)"]])]])], ["h-text2", _uM([[".header ", _uM([["marginTop", 4], ["fontSize", 14], ["color", "var(--rice-text-color-2)"]])]])], ["card", _pS(_uM([["paddingTop", 12], ["paddingRight", 15], ["paddingBottom", 12], ["paddingLeft", 15], ["marginTop", 8]]))]])]
