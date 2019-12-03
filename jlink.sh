#!/bin/sh
cd target
rm -rf jruntime
jlink @../jlink.args
