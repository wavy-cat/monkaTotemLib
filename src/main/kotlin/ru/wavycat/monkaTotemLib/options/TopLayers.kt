/*
 *                  Copyright WavyCat 2024.
 *  Distributed under the Boost Software License, Version 1.0.
 *         (See accompanying file LICENSE or copy at
 *           https://www.boost.org/LICENSE_1_0.txt)
 */

package ru.wavycat.monkaTotemLib.options

enum class TopLayers(val value: String) {
    NOTHING("nothing"),
    ALL("all"),
    ONLY_HEAD("only_head"),
    ONLY_TORSO("only_torso"),
    ONLY_HANDS("only_hands"),
    HEAD_AND_TORSO("head_and_torso"),
    HEAD_AND_HANDS("head_and_hands"),
}