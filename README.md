# Intern_Task_Yumemi

## 作成したアプリのスクリーンショット
![screenshot](https://user-images.githubusercontent.com/49048577/120358373-603f8c00-c341-11eb-9e5c-5225e18da95b.png)


## 工夫したこと
- GitHubの活用
  - issueによるタスク管理
  - issueとcommitの紐付け
  - branchを切って開発
  - PRの利用
- 非同期処理
  - Coroutinesを利用
- ライフサイクルの意識
  - 今回のアプリは画面が表示された後に情報が変化しないため，主にonCreate内に実装した．
- UI/UX
  - このアプリを使うユーザーはどんな情報を欲しいか考えてアプリを作成した
  - Googleの強いエンジニアが一覧表示されているため，詳細画面で彼らのフォロワー数やフォロー数，リポジトリの一覧を取得し，表示させた．
  - 色使いやViewの丸みはGitHubを意識した．


## 挑戦したができなかったこと
- 依存性の解決 (DI)
  - DIやDaggerについて調べたが，時間的に実装が間に合わなかった．
- テストコードの実装 
  - Daggerの他にUIテストを作成できるEspressoを調べたが，こちらも時間的な制約により実装を断念した．


## 技術課題を通じて学んだこと
- チーム開発を見据えたGitHubの利用方法
  - そもそもissueの使い方（めっちゃ便利）
  - 接頭辞を用いたcommitメッセージの書き方
  - issueとcommitの紐付け方法
  - branchを切って開発して，PRを出してmergeする一連の流れ
- テストコードとは何か
  - プロのエンジニアがどういうコードを書いているのかを少しだけ知れた．
  - 今回は実装できなかったので，DaggerやEspressoを用いてテストコードを書きたい．
- （改めて）WebAPIの利用方法
- （改めて）Coroutinesによる非同期処理
  - 正直言うと，非同期処理についてもっとちゃんと理解したい．
- （改めて）RecyclerViewの実装
- READMEの必要性

## 感想
技術課題ということで，インターンの選考における課題の一つでしたが，十分にたくさんのことを学び，気付き，知識を整理することができました．
特に，普段個人開発をしている時には使わないPRやissueを意識して使ったことで，GitHubの扱いにも慣れ，便利だと感じられるようになりました．
またテストコードについて調べられ，新しい知識を得ることもできました．時間的に実装が間に合わなかったことが非常に悔しいので，個人的な宿題として取り組みます．
短い期間ではありましたが，自分一人では得られなかったであろう学びや気付きを得ることができ，非常に満足しています．何より楽しかったです．
このような機会を作ってくださり，本当にありがとうございました！
