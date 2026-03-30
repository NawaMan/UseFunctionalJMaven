#!/bin/bash
# Wait for Caddy admin API to be ready, then reload with wildcard cert
(
P="${TLS_PROXY_PORT:-10443}";C="${CODE_SERVER_PORT:-10000}"
printf ":$P\n  tls /opt/booth-tls/fullchain.pem /opt/booth-tls/privkey.pem\n  reverse_proxy localhost:$C\n" > /tmp/Caddyfile.wildcard
for i in $(seq 1 30); do
    if caddy reload --config /tmp/Caddyfile.wildcard --adapter caddyfile --address localhost:2019 2>/dev/null; then
        exit 0
    fi
    sleep 1
done
) &
