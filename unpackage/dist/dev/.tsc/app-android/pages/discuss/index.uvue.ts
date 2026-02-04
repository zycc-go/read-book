
const __sfc__ = defineComponent({
  __name: 'index',
  setup(__props) {
const __ins = getCurrentInstance()!;
const _ctx = __ins.proxy as InstanceType<typeof __sfc__>;
const _cache = __ins.renderCache;

	const title = ref('discuss')

return (): any | null => {

  return _cE("view", null, [
    _cE("image", _uM({
      class: "logo",
      src: "/static/logo.png"
    })),
    _cE("text", _uM({ class: "title" }), _tD(unref(title)), 1 /* TEXT */)
  ])
}
}

})
export default __sfc__
const GenPagesDiscussIndexStyles = [_uM([["logo", _pS(_uM([["height", 100], ["width", 100], ["marginTop", 100], ["marginRight", "auto"], ["marginBottom", 25], ["marginLeft", "auto"]]))], ["title", _pS(_uM([["fontSize", 18], ["color", "#8f8f94"], ["textAlign", "center"]]))]])]
