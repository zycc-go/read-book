import _easycom_rice_button from '@/uni_modules/rice-ui/components/rice-button/rice-button.uvue'

const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const title = ref('bookcase')

return (): any | null => {

const _component_rice_button = resolveEasyComponent("rice-button",_easycom_rice_button)

  return _cE("view", null, [
    _cE("text", _uM({ class: "title" }), _tD(unref(title)), 1 /* TEXT */),
    _cV(_component_rice_button, _uM({
      type: "primary",
      text: "确定"
    }))
  ])
}
}

})
export default __sfc__
const GenPagesBookcaseIndexStyles = [_uM([["logo", _pS(_uM([["height", 100], ["width", 100], ["marginTop", 100], ["marginRight", "auto"], ["marginBottom", 25], ["marginLeft", "auto"]]))], ["title", _pS(_uM([["fontSize", 18], ["color", "#8f8f94"], ["textAlign", "center"]]))]])]
