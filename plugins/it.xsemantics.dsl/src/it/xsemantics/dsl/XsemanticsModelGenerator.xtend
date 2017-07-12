package it.xsemantics.dsl

import java.util.List
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.generator.trace.LocationData
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.util.ITextRegionWithLineInformation
import org.eclipse.xtext.xbase.compiler.FileHeaderAdapter
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import com.google.inject.Inject
import org.eclipse.xtext.documentation.IFileHeaderProvider

class XsemanticsModelGenerator extends JvmModelGenerator {
	@Inject protected extension ReflectExtensions

	override void generateFileHeader(JvmDeclaredType declType, ITreeAppendable appendable, GeneratorConfig config) {
		val fileHeaderAdapter = declType.eAdapters.filter(FileHeaderAdapter).head
		if (!fileHeaderAdapter?.headerText.nullOrEmpty) {
			val fileHeaderProvider = get('fileHeaderProvider') as IFileHeaderProvider
			val fileHeaderNodes = fileHeaderProvider.getFileHeaderNodes(declType.eResource)
			generateFileHeaderComment(fileHeaderAdapter.headerText, fileHeaderNodes, appendable, config)
		}
	}

	def protected generateFileHeaderComment(String headerComment, List<INode> documentationNodes,
		ITreeAppendable appendable, GeneratorConfig config) {

		val doc = new StringConcatenation()
		doc.append(headerComment)
		if (!documentationNodes.empty) {
			var documentationTrace = ITextRegionWithLineInformation.EMPTY_REGION
			for (node : documentationNodes) {
				documentationTrace = documentationTrace.merge(node.textRegionWithLineInformation)
			}
			appendable.trace(new LocationData(documentationTrace, null)).append(doc.toString)
			appendable.newLine

		} else {
			appendable.append(doc.toString).newLine
		}
	}

}
