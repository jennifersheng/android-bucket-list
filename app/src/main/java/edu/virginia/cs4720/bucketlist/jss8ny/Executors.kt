package edu.virginia.cs4720.bucketlist.jss8ny

import java.util.concurrent.Executors

// Resource:
// https://gist.github.com/florina-muntenescu/697e543652b03d3d2a06703f5d6b44b5
private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

fun ioThread(f : () -> Unit) {
    IO_EXECUTOR.execute(f)
}