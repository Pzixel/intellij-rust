/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

package org.rust.ide.annotator.fixes

import org.rust.MockRustcVersion
import org.rust.ide.annotator.RsAnnotatorTestBase
import org.rust.ide.annotator.RsErrorAnnotator

class ReplaceFeatureAttributeFixTest : RsAnnotatorTestBase(RsErrorAnnotator::class) {
    @MockRustcVersion("1.47.0-nightly")
    fun `test replace min_const_generics feature with const_generics feature`() =
        checkFixByText("Replace `min_const_generics` feature with `const_generics` feature", """
            #![feature(min_const_generics)]
            struct S;
            fn foo<const C: <error>S/*caret*/</error>>() {}
        """, """
            #![feature(const_generics)]
            struct S;
            fn foo<const C: S>() {}
        """)
}
