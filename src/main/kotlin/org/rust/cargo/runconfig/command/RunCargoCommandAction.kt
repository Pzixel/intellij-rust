/*
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

package org.rust.cargo.runconfig.command

import com.intellij.ide.actions.runAnything.RunAnythingManager
import com.intellij.openapi.actionSystem.AnActionEvent
import org.rust.ide.actions.runAnything.cargo.CargoRunAnythingProvider.Companion.HELP_COMMAND

class RunCargoCommandAction : RunCargoCommandActionBase() {
    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val runAnythingManager = RunAnythingManager.getInstance(project)
        runAnythingManager.show("$HELP_COMMAND ", false, e)
    }
}
