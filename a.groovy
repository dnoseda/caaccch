String key = "CACHE_DUPLICATED_PAYMENTS_CONFIG_ENDPOINT"

String ret = key - "CACHE_"

ret = ret - "_ENDPOINT"

ret = ret.toLowerCase().replaceAll(/_([a-z])/,{ all, cap ->
    return cap.toUpperCase()
})

ret = "${ret}Cache"

println ret
