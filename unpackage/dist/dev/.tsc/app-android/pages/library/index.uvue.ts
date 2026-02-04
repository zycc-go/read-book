import _easycom_rice_navbar from '@/uni_modules/rice-ui/components/rice-navbar/rice-navbar.uvue'

const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const title = ref('library')

return (): any | null => {

const _component_rice_navbar = resolveEasyComponent("rice-navbar",_easycom_rice_navbar)

  return _cE("view", null, [
    _cV(_component_rice_navbar, _uM({
      "left-arrow": false,
      "bg-color": "#f8f8f8"
    }))
  ])
}
}

})
export default __sfc__
const GenPagesLibraryIndexStyles = [_uM([["logo", _pS(_uM([["height", 100], ["width", 100], ["marginTop", 100], ["marginRight", "auto"], ["marginBottom", 25], ["marginLeft", "auto"]]))], ["title", _pS(_uM([["fontSize", 18], ["color", "#8f8f94"], ["textAlign", "center"]]))]])]
