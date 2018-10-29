package com.xy2401.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.junit.Test;

public class TestA {

	String path = "F:\\code\\github\\github";

	@Test
	public void lsgit() throws IOException {

		// 列举所有的目录
		Files.list(Paths.get(path)).filter(Files::isDirectory).forEach(System.out::println);

		Files.list(Paths.get(path)).filter(Files::isDirectory).forEach(file -> {
			System.out.println("test" + file.toString());
			try {

				Repository repository = new FileRepositoryBuilder().setGitDir(file.resolve(".git").toFile())
						// .findGitDir()
						.build();

				System.out.println("Having repository: " + repository.getDirectory());

				try (Git git = new Git(repository)) {
					Iterable<RevCommit> commits = git.log().all().call();
					int count = 0;
					for (RevCommit commit : commits) {

						commit.getCommitTime();

						commit.getCommitterIdent();// 提交人信息

						count++;
					}
					System.out.println(count);
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		);

	}

	@Test
	public void ls() throws Exception {

		// 列举所有文件/文件夹
		Files.list(Paths.get(path)).forEach(System.out::println);

		// 列举所有普通文件
		Files.list(Paths.get(path)).filter(Files::isRegularFile).forEach(System.out::println);

	}

}
