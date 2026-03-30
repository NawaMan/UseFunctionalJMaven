#!/bin/bash
T="/usr/share/startup.d/50-cb-tls--startup.sh"
[ -f "$T" ] && sudo sed -i 's/localhost:${TLS_PROXY_PORT}/:${TLS_PROXY_PORT}/g' "$T"
